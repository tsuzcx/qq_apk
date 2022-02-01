package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.MessageForTofuAskAnonymously;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.constant.AnonymousConstant;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousHandler;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/item/TofuAskAnonymouslyItemBuilder;", "Lcom/tencent/mobileqq/activity/aio/AbstractChatItemBuilder;", "Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "adapter", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/widget/BaseAdapter;Landroid/content/Context;Lcom/tencent/mobileqq/activity/aio/SessionInfo;)V", "mAnonymousObserver", "Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/handler/AnonymousObserver;", "mAvatarMap", "Ljava/util/HashMap;", "", "Landroid/widget/ImageView;", "Lkotlin/collections/HashMap;", "mCurrentQuestId", "mDecoder", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "mHolder", "Lcom/tencent/mobileqq/activity/aio/item/TofuAskAnonymouslyItemBuilder$Holder;", "mLatestAnonymousInfo", "Lcom/tencent/mobileqq/activity/aio/item/TofuAskAnonymouslyItemBuilder$LatestAnonymousInfo;", "mMsg", "Lcom/tencent/mobileqq/data/MessageForTofuAskAnonymously;", "randomHeadBgIndex", "", "bindEventListener", "", "anonymousInfo", "Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/bean/AnonymousQuestion;", "holder", "destroy", "getFaceBitmap", "Landroid/graphics/Bitmap;", "uin", "headView", "getItemView", "Landroid/view/View;", "message", "Lcom/tencent/mobileqq/data/MessageRecord;", "viewHolder", "Lcom/tencent/mobileqq/activity/aio/AbstractChatItemBuilder$ViewHolder;", "convertView", "parent", "Landroid/widget/LinearLayout;", "longClick", "Lcom/tencent/mobileqq/activity/aio/OnLongClickAndTouchListener;", "getMenuItem", "", "Lcom/tencent/mobileqq/utils/dialogutils/QQCustomMenuItem;", "view", "(Landroid/view/View;)[Lcom/tencent/mobileqq/utils/dialogutils/QQCustomMenuItem;", "initHolder", "newHolder", "onDecodeTaskCompleted", "remainingTasks", "type", "avatar", "setLikeUi", "mPraised", "", "tvLike", "Landroid/widget/TextView;", "ivLike", "totalPraiseCount", "", "shouldUseLatestInfo", "questId", "updateMsgInfo", "updateMsgView", "Companion", "Holder", "LatestAnonymousInfo", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TofuAskAnonymouslyItemBuilder
  extends AbstractChatItemBuilder
  implements DecodeTaskCompletionListener
{
  public static final TofuAskAnonymouslyItemBuilder.Companion a;
  private int jdField_a_of_type_Int;
  private TofuAskAnonymouslyItemBuilder.Holder jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder = new TofuAskAnonymouslyItemBuilder.Holder();
  private TofuAskAnonymouslyItemBuilder.LatestAnonymousInfo jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$LatestAnonymousInfo = new TofuAskAnonymouslyItemBuilder.LatestAnonymousInfo(false, null, 0L, false, 0L, 0L, 63, null);
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private MessageForTofuAskAnonymously jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously = new MessageForTofuAskAnonymously();
  private final AnonymousObserver jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousHandlerAnonymousObserver = (AnonymousObserver)new TofuAskAnonymouslyItemBuilder.mAnonymousObserver.1(this);
  private String jdField_a_of_type_JavaLangString = "";
  private final HashMap<String, ImageView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Companion = new TofuAskAnonymouslyItemBuilder.Companion(null);
  }
  
  public TofuAskAnonymouslyItemBuilder(@NotNull QQAppInterface paramQQAppInterface, @NotNull BaseAdapter paramBaseAdapter, @NotNull Context paramContext, @NotNull SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    double d1 = Math.random();
    double d2 = AnonymousConstant.HEAD_BG_COLOR.length;
    Double.isNaN(d2);
    this.jdField_a_of_type_Int = ((int)(d1 * d2));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)paramQQAppInterface);
    paramBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (paramBaseAdapter == null) {
      Intrinsics.throwNpe();
    }
    paramBaseAdapter.setDecodeTaskCompletionListener((DecodeTaskCompletionListener)this);
    paramQQAppInterface.addObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousHandlerAnonymousObserver);
  }
  
  private final View a(View paramView, TofuAskAnonymouslyItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558833, null);
      if (paramHolder != null) {
        paramHolder.a((ViewGroup)paramView.findViewById(2131374156));
      }
      if (paramHolder != null) {
        paramHolder.b((ViewGroup)paramView.findViewById(2131374161));
      }
      if (paramHolder != null) {
        paramHolder.c((ViewGroup)paramView.findViewById(2131374155));
      }
      if (paramHolder != null) {
        paramHolder.a((ImageView)paramView.findViewById(2131374159));
      }
      if (paramHolder != null) {
        paramHolder.b((ImageView)paramView.findViewById(2131374160));
      }
      if (paramHolder != null) {
        paramHolder.c((ImageView)paramView.findViewById(2131374153));
      }
      if (paramHolder != null) {
        paramHolder.d((ImageView)paramView.findViewById(2131374152));
      }
      if (paramHolder != null) {
        paramHolder.e((ImageView)paramView.findViewById(2131374154));
      }
      if (paramHolder != null) {
        paramHolder.a((TextView)paramView.findViewById(2131374167));
      }
      if (paramHolder != null) {
        paramHolder.d((ViewGroup)paramView.findViewById(2131374157));
      }
      if (paramHolder != null) {
        paramHolder.g((ImageView)paramView.findViewById(2131374147));
      }
      if (paramHolder != null) {
        paramHolder.f((ImageView)paramView.findViewById(2131374148));
      }
      if (paramHolder != null) {
        paramHolder.b((TextView)paramView.findViewById(2131374163));
      }
      if (paramHolder != null) {
        paramHolder.h((ImageView)paramView.findViewById(2131374149));
      }
      if (paramHolder != null) {
        paramHolder.c((TextView)paramView.findViewById(2131374164));
      }
      if (paramHolder != null) {
        paramHolder.d((TextView)paramView.findViewById(2131374166));
      }
      if (paramHolder != null) {
        paramHolder.i((ImageView)paramView.findViewById(2131374151));
      }
      if (paramHolder != null) {
        paramHolder.e((TextView)paramView.findViewById(2131374165));
      }
      localView = paramView;
      if (paramHolder != null)
      {
        paramHolder.j((ImageView)paramView.findViewById(2131374150));
        localView = paramView;
      }
    }
    return localView;
  }
  
  private final void a(AnonymousQuestion paramAnonymousQuestion, TofuAskAnonymouslyItemBuilder.Holder paramHolder)
  {
    paramAnonymousQuestion = (View.OnClickListener)new TofuAskAnonymouslyItemBuilder.bindEventListener.listener.1(this, paramAnonymousQuestion, paramHolder);
    Object localObject = paramHolder.d();
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(paramAnonymousQuestion);
    }
    localObject = paramHolder.i();
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(paramAnonymousQuestion);
    }
    localObject = paramHolder.e();
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(paramAnonymousQuestion);
    }
    localObject = paramHolder.j();
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(paramAnonymousQuestion);
    }
    localObject = paramHolder.c();
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(paramAnonymousQuestion);
    }
    localObject = paramHolder.h();
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(paramAnonymousQuestion);
    }
    localObject = paramHolder.e();
    if (localObject != null) {
      ((TextView)localObject).setOnTouchListener((View.OnTouchListener)UITools.a);
    }
    localObject = paramHolder.j();
    if (localObject != null) {
      ((ImageView)localObject).setOnTouchListener((View.OnTouchListener)UITools.a);
    }
    paramHolder = paramHolder.a();
    if (paramHolder != null) {
      paramHolder.setOnClickListener(paramAnonymousQuestion);
    }
  }
  
  private final void a(boolean paramBoolean, TextView paramTextView, ImageView paramImageView, long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext");
    localObject1 = ((Context)localObject1).getResources().getDrawable(2130845981);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext.resources.getDr…e_achivement_like_normal)");
    int i = Color.parseColor("#FFB0B3BF");
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext");
      localObject1 = ((Context)localObject1).getResources().getDrawable(AnonymousConstant.LIKE_IV_DRAWABLE);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext.resources.getDr…onstant.LIKE_IV_DRAWABLE)");
      i = AnonymousConstant.LIKE_IV_COLOR;
    }
    if (QLog.isColorLevel())
    {
      Object localObject2 = StringCompanionObject.INSTANCE;
      localObject2 = new Object[1];
      localObject2[0] = Boolean.valueOf(paramBoolean);
      localObject2 = String.format("setLikeUi() mPraised=%b", Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.lang.String.format(format, *args)");
      QLog.d("TofuAskAnonymouslyItemBuilder", 2, (String)localObject2);
    }
    paramTextView.setText((CharSequence)Utils.b((int)paramLong));
    paramTextView.setTextColor(i);
    paramImageView.setImageDrawable((Drawable)localObject1);
  }
  
  private final boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty((CharSequence)paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$LatestAnonymousInfo.a())
    {
      bool1 = bool2;
      if (StringsKt.equals$default(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$LatestAnonymousInfo.a(), false, 2, null)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final void b()
  {
    if (a(this.jdField_a_of_type_JavaLangString))
    {
      AnonymousQuestion localAnonymousQuestion = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.getAskAnonymouslyQuestion();
      if (localAnonymousQuestion != null) {
        localAnonymousQuestion.mPraised = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$LatestAnonymousInfo.b();
      }
      localAnonymousQuestion = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.getAskAnonymouslyQuestion();
      if (localAnonymousQuestion != null) {
        localAnonymousQuestion.mTotalPraiseCount = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$LatestAnonymousInfo.a();
      }
      localAnonymousQuestion = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.getAskAnonymouslyQuestion();
      if (localAnonymousQuestion != null) {
        localAnonymousQuestion.mTotalCommentCount = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$LatestAnonymousInfo.b();
      }
      localAnonymousQuestion = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.getAskAnonymouslyQuestion();
      if (localAnonymousQuestion != null) {
        localAnonymousQuestion.mTotalViewCount = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$LatestAnonymousInfo.c();
      }
    }
  }
  
  private final void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.getAskAnonymouslyQuestion();
    if (localObject1 != null)
    {
      boolean bool = ((AnonymousQuestion)localObject1).mPraised;
      TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.d();
      if (localTextView == null) {
        Intrinsics.throwNpe();
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.i();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      a(bool, localTextView, (ImageView)localObject2, ((AnonymousQuestion)localObject1).mTotalPraiseCount);
      localTextView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.e();
      if (localTextView != null) {
        localTextView.setText((CharSequence)Utils.b((int)((AnonymousQuestion)localObject1).mTotalCommentCount));
      }
      localTextView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.c();
      if (localTextView != null)
      {
        localObject2 = StringCompanionObject.INSTANCE;
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131698623);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "mContext.getString(R.str…q_anonymous_browse_count)");
        Object[] arrayOfObject = new Object[1];
        if (((AnonymousQuestion)localObject1).mTotalViewCount > 0L) {
          localObject1 = Utils.b((int)((AnonymousQuestion)localObject1).mTotalViewCount);
        } else {
          localObject1 = Long.valueOf(((AnonymousQuestion)localObject1).mTotalViewCount);
        }
        arrayOfObject[0] = localObject1;
        localObject1 = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
        localTextView.setText((CharSequence)localObject1);
      }
    }
  }
  
  @Nullable
  public final Bitmap a(@Nullable String paramString, @Nullable ImageView paramImageView)
  {
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (paramImageView != null))
    {
      try
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = ((IFaceDecoder)localObject).getBitmapFromCache(1, paramString);
        if (localObject != null) {
          return localObject;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        if (!((IFaceDecoder)localObject).isPausing())
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          ((IFaceDecoder)localObject).requestDecodeFace(paramString, 200, true);
          localObject = (Map)this.jdField_a_of_type_JavaUtilHashMap;
          if (paramString == null) {
            Intrinsics.throwNpe();
          }
          ((Map)localObject).put(paramString, paramImageView);
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return ImageUtil.f();
    }
    return null;
  }
  
  @Nullable
  protected View a(@Nullable MessageRecord paramMessageRecord, @Nullable AbstractChatItemBuilder.ViewHolder paramViewHolder, @Nullable View paramView, @Nullable LinearLayout paramLinearLayout, @Nullable OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (paramMessageRecord != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously = ((MessageForTofuAskAnonymously)paramMessageRecord);
      if (paramViewHolder != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder = ((TofuAskAnonymouslyItemBuilder.Holder)paramViewHolder);
        paramViewHolder = a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.uniseq);
        paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder;
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.frienduin;
        Intrinsics.checkExpressionValueIsNotNull(paramView, "mMsg.frienduin");
        paramMessageRecord.a(paramView);
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.getAskAnonymouslyQuestion();
        if (paramView != null)
        {
          paramView.mOwnerUin = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.a());
          paramMessageRecord = paramView.mId;
          Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "it.mId");
          this.jdField_a_of_type_JavaLangString = paramMessageRecord;
          b();
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.a();
          if (paramMessageRecord != null) {
            paramMessageRecord.setText((CharSequence)new QQText((CharSequence)QzoneEmotionUtils.emCodesToQQcodes(paramView.mQuest), 3, 16));
          }
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.b();
          if (paramMessageRecord != null) {
            paramMessageRecord.setText((CharSequence)new QQText((CharSequence)QzoneEmotionUtils.emCodesToQQcodes(paramView.mAnswer), 3, 16));
          }
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.g();
          if (paramMessageRecord != null) {
            paramMessageRecord.setImageBitmap(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.g()));
          }
          paramLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.c();
          if (paramLinearLayout != null)
          {
            paramMessageRecord = StringCompanionObject.INSTANCE;
            paramOnLongClickAndTouchListener = this.jdField_a_of_type_AndroidContentContext.getString(2131698623);
            Intrinsics.checkExpressionValueIsNotNull(paramOnLongClickAndTouchListener, "mContext.getString(R.str…q_anonymous_browse_count)");
            Object[] arrayOfObject = new Object[1];
            if (paramView.mTotalViewCount > 0L) {
              paramMessageRecord = Utils.b((int)paramView.mTotalViewCount);
            } else {
              paramMessageRecord = Long.valueOf(paramView.mTotalViewCount);
            }
            arrayOfObject[0] = paramMessageRecord;
            paramMessageRecord = String.format(paramOnLongClickAndTouchListener, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
            Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "java.lang.String.format(format, *args)");
            paramLinearLayout.setText((CharSequence)paramMessageRecord);
          }
          if ((ThemeUtil.isSimpleDayTheme(false)) && (!ThemeUtil.isNowThemeIsNight((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)))
          {
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.b();
            if (paramMessageRecord != null) {
              paramMessageRecord.setBackgroundResource(2130844849);
            }
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.c();
            if (paramMessageRecord != null) {
              paramMessageRecord.setBackgroundResource(2130844848);
            }
          }
          if (ThemeUtil.isInNightMode((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.b();
            if (paramMessageRecord != null) {
              paramMessageRecord.setBackgroundResource(2130845909);
            }
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.c();
            if (paramMessageRecord != null) {
              paramMessageRecord.setBackgroundResource(2130845898);
            }
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.a();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130844822);
            }
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.b();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130844823);
            }
          }
          if (SimpleUIUtil.a())
          {
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.d();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130845915);
            }
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.c();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130845912);
            }
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.e();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130845914);
            }
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.f();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130845900);
            }
          }
          else
          {
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.d();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130845910);
            }
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.c();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130845911);
            }
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.e();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130845913);
            }
            paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.f();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130845899);
            }
          }
          int i = this.jdField_a_of_type_Int;
          int j = AnonymousConstant.HEAD_BG_COLOR.length;
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.c();
          if (paramMessageRecord != null) {
            paramMessageRecord.clearColorFilter();
          }
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.c();
          if (paramMessageRecord != null) {
            paramMessageRecord.setColorFilter(AnonymousConstant.HEAD_BG_COLOR[(i % j)]);
          }
          boolean bool = paramView.mPraised;
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.d();
          if (paramMessageRecord == null) {
            Intrinsics.throwNpe();
          }
          paramLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.i();
          if (paramLinearLayout == null) {
            Intrinsics.throwNpe();
          }
          a(bool, paramMessageRecord, paramLinearLayout, paramView.mTotalPraiseCount);
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.e();
          if (paramMessageRecord != null) {
            paramMessageRecord.setText((CharSequence)Utils.b((int)paramView.mTotalCommentCount));
          }
          a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder);
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ANONYMOUS_ANSWER_HANDLER);
          if (paramMessageRecord != null)
          {
            paramMessageRecord = (AnonymousHandler)paramMessageRecord;
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.a())
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.a(true);
              ThreadManagerV2.excute((Runnable)new TofuAskAnonymouslyItemBuilder.getItemView..inlined.let.lambda.1(this), 128, null, true);
              try
              {
                paramMessageRecord.getLatestAnonymousInfo(paramView);
              }
              catch (Exception paramMessageRecord)
              {
                paramView = new StringBuilder();
                paramView.append("getLatestAnonymousInfo exception ");
                paramView.append(paramMessageRecord);
                QLog.e("TofuAskAnonymouslyItemBuilder", 1, paramView.toString());
              }
              ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAskAnonymouslyItemBuilder$Holder.a(), "0X800B5C0", "0X800B5C0", 0, 0, "", "", "", "");
              return paramViewHolder;
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousHandler");
          }
        }
        return paramViewHolder;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.item.TofuAskAnonymouslyItemBuilder.Holder");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForTofuAskAnonymously");
  }
  
  @NotNull
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return (AbstractChatItemBuilder.ViewHolder)new TofuAskAnonymouslyItemBuilder.Holder();
  }
  
  public void a()
  {
    super.a();
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null)
    {
      if (localIFaceDecoder == null) {
        Intrinsics.throwNpe();
      }
      localIFaceDecoder.destory();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousHandlerAnonymousObserver);
  }
  
  @NotNull
  public QQCustomMenuItem[] a(@Nullable View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, @Nullable String paramString, @Nullable Bitmap paramBitmap)
  {
    paramString = (ImageView)((Map)this.jdField_a_of_type_JavaUtilHashMap).get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAskAnonymouslyItemBuilder
 * JD-Core Version:    0.7.0.1
 */