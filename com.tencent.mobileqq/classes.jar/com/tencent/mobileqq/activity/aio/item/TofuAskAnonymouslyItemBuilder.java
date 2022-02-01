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
  public static final TofuAskAnonymouslyItemBuilder.Companion e = new TofuAskAnonymouslyItemBuilder.Companion(null);
  private int f;
  private IFaceDecoder g;
  private final HashMap<String, ImageView> h = new HashMap();
  private TofuAskAnonymouslyItemBuilder.LatestAnonymousInfo i = new TofuAskAnonymouslyItemBuilder.LatestAnonymousInfo(false, null, 0L, false, 0L, 0L, 63, null);
  private String j = "";
  private TofuAskAnonymouslyItemBuilder.Holder k = new TofuAskAnonymouslyItemBuilder.Holder();
  private MessageForTofuAskAnonymously l = new MessageForTofuAskAnonymously();
  private final AnonymousObserver m = (AnonymousObserver)new TofuAskAnonymouslyItemBuilder.mAnonymousObserver.1(this);
  
  public TofuAskAnonymouslyItemBuilder(@NotNull QQAppInterface paramQQAppInterface, @NotNull BaseAdapter paramBaseAdapter, @NotNull Context paramContext, @NotNull SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    double d1 = Math.random();
    double d2 = AnonymousConstant.HEAD_BG_COLOR.length;
    Double.isNaN(d2);
    this.f = ((int)(d1 * d2));
    this.g = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)paramQQAppInterface);
    paramBaseAdapter = this.g;
    if (paramBaseAdapter == null) {
      Intrinsics.throwNpe();
    }
    paramBaseAdapter.setDecodeTaskCompletionListener((DecodeTaskCompletionListener)this);
    paramQQAppInterface.addObserver((BusinessObserver)this.m);
  }
  
  private final View a(View paramView, TofuAskAnonymouslyItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(2131624453, null);
      if (paramHolder != null) {
        paramHolder.a((ViewGroup)paramView.findViewById(2131442251));
      }
      if (paramHolder != null) {
        paramHolder.b((ViewGroup)paramView.findViewById(2131442256));
      }
      if (paramHolder != null) {
        paramHolder.c((ViewGroup)paramView.findViewById(2131442250));
      }
      if (paramHolder != null) {
        paramHolder.a((ImageView)paramView.findViewById(2131442254));
      }
      if (paramHolder != null) {
        paramHolder.b((ImageView)paramView.findViewById(2131442255));
      }
      if (paramHolder != null) {
        paramHolder.c((ImageView)paramView.findViewById(2131442248));
      }
      if (paramHolder != null) {
        paramHolder.d((ImageView)paramView.findViewById(2131442247));
      }
      if (paramHolder != null) {
        paramHolder.e((ImageView)paramView.findViewById(2131442249));
      }
      if (paramHolder != null) {
        paramHolder.a((TextView)paramView.findViewById(2131442262));
      }
      if (paramHolder != null) {
        paramHolder.d((ViewGroup)paramView.findViewById(2131442252));
      }
      if (paramHolder != null) {
        paramHolder.g((ImageView)paramView.findViewById(2131442242));
      }
      if (paramHolder != null) {
        paramHolder.f((ImageView)paramView.findViewById(2131442243));
      }
      if (paramHolder != null) {
        paramHolder.b((TextView)paramView.findViewById(2131442258));
      }
      if (paramHolder != null) {
        paramHolder.h((ImageView)paramView.findViewById(2131442244));
      }
      if (paramHolder != null) {
        paramHolder.c((TextView)paramView.findViewById(2131442259));
      }
      if (paramHolder != null) {
        paramHolder.d((TextView)paramView.findViewById(2131442261));
      }
      if (paramHolder != null) {
        paramHolder.i((ImageView)paramView.findViewById(2131442246));
      }
      if (paramHolder != null) {
        paramHolder.e((TextView)paramView.findViewById(2131442260));
      }
      localView = paramView;
      if (paramHolder != null)
      {
        paramHolder.j((ImageView)paramView.findViewById(2131442245));
        localView = paramView;
      }
    }
    return localView;
  }
  
  private final void a(AnonymousQuestion paramAnonymousQuestion, TofuAskAnonymouslyItemBuilder.Holder paramHolder)
  {
    paramAnonymousQuestion = (View.OnClickListener)new TofuAskAnonymouslyItemBuilder.bindEventListener.listener.1(this, paramAnonymousQuestion, paramHolder);
    Object localObject = paramHolder.q();
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(paramAnonymousQuestion);
    }
    localObject = paramHolder.r();
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(paramAnonymousQuestion);
    }
    localObject = paramHolder.s();
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(paramAnonymousQuestion);
    }
    localObject = paramHolder.t();
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(paramAnonymousQuestion);
    }
    localObject = paramHolder.p();
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(paramAnonymousQuestion);
    }
    localObject = paramHolder.o();
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(paramAnonymousQuestion);
    }
    localObject = paramHolder.s();
    if (localObject != null) {
      ((TextView)localObject).setOnTouchListener((View.OnTouchListener)UITools.a);
    }
    localObject = paramHolder.t();
    if (localObject != null) {
      ((ImageView)localObject).setOnTouchListener((View.OnTouchListener)UITools.a);
    }
    paramHolder = paramHolder.c();
    if (paramHolder != null) {
      paramHolder.setOnClickListener(paramAnonymousQuestion);
    }
  }
  
  private final void a(boolean paramBoolean, TextView paramTextView, ImageView paramImageView, long paramLong)
  {
    Object localObject1 = this.c;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext");
    localObject1 = ((Context)localObject1).getResources().getDrawable(2130847451);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext.resources.getDr…e_achivement_like_normal)");
    int n = Color.parseColor("#FFB0B3BF");
    if (paramBoolean)
    {
      localObject1 = this.c;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext");
      localObject1 = ((Context)localObject1).getResources().getDrawable(AnonymousConstant.LIKE_IV_DRAWABLE);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext.resources.getDr…onstant.LIKE_IV_DRAWABLE)");
      n = AnonymousConstant.LIKE_IV_COLOR;
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
    paramTextView.setText((CharSequence)Utils.e((int)paramLong));
    paramTextView.setTextColor(n);
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
    if (this.i.a())
    {
      bool1 = bool2;
      if (StringsKt.equals$default(paramString, this.i.b(), false, 2, null)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final void c()
  {
    if (a(this.j))
    {
      AnonymousQuestion localAnonymousQuestion = this.l.getAskAnonymouslyQuestion();
      if (localAnonymousQuestion != null) {
        localAnonymousQuestion.mPraised = this.i.d();
      }
      localAnonymousQuestion = this.l.getAskAnonymouslyQuestion();
      if (localAnonymousQuestion != null) {
        localAnonymousQuestion.mTotalPraiseCount = this.i.c();
      }
      localAnonymousQuestion = this.l.getAskAnonymouslyQuestion();
      if (localAnonymousQuestion != null) {
        localAnonymousQuestion.mTotalCommentCount = this.i.e();
      }
      localAnonymousQuestion = this.l.getAskAnonymouslyQuestion();
      if (localAnonymousQuestion != null) {
        localAnonymousQuestion.mTotalViewCount = this.i.f();
      }
    }
  }
  
  private final void d()
  {
    Object localObject1 = this.l.getAskAnonymouslyQuestion();
    if (localObject1 != null)
    {
      boolean bool = ((AnonymousQuestion)localObject1).mPraised;
      TextView localTextView = this.k.q();
      if (localTextView == null) {
        Intrinsics.throwNpe();
      }
      Object localObject2 = this.k.r();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      a(bool, localTextView, (ImageView)localObject2, ((AnonymousQuestion)localObject1).mTotalPraiseCount);
      localTextView = this.k.s();
      if (localTextView != null) {
        localTextView.setText((CharSequence)Utils.e((int)((AnonymousQuestion)localObject1).mTotalCommentCount));
      }
      localTextView = this.k.p();
      if (localTextView != null)
      {
        localObject2 = StringCompanionObject.INSTANCE;
        localObject2 = this.c.getString(2131896570);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "mContext.getString(R.str…q_anonymous_browse_count)");
        Object[] arrayOfObject = new Object[1];
        if (((AnonymousQuestion)localObject1).mTotalViewCount > 0L) {
          localObject1 = Utils.e((int)((AnonymousQuestion)localObject1).mTotalViewCount);
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
        Object localObject = this.g;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = ((IFaceDecoder)localObject).getBitmapFromCache(1, paramString);
        if (localObject != null) {
          return localObject;
        }
        localObject = this.g;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        if (!((IFaceDecoder)localObject).isPausing())
        {
          localObject = this.g;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          ((IFaceDecoder)localObject).requestDecodeFace(paramString, 200, true);
          localObject = (Map)this.h;
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
      return ImageUtil.k();
    }
    return null;
  }
  
  @Nullable
  protected View a(@Nullable MessageRecord paramMessageRecord, @Nullable AbstractChatItemBuilder.ViewHolder paramViewHolder, @Nullable View paramView, @Nullable LinearLayout paramLinearLayout, @Nullable OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (paramMessageRecord != null)
    {
      this.l = ((MessageForTofuAskAnonymously)paramMessageRecord);
      if (paramViewHolder != null)
      {
        this.k = ((TofuAskAnonymouslyItemBuilder.Holder)paramViewHolder);
        paramViewHolder = a(paramView, this.k);
        this.k.a(this.l.uniseq);
        paramMessageRecord = this.k;
        paramView = this.l.frienduin;
        Intrinsics.checkExpressionValueIsNotNull(paramView, "mMsg.frienduin");
        paramMessageRecord.a(paramView);
        paramView = this.l.getAskAnonymouslyQuestion();
        if (paramView != null)
        {
          paramView.mOwnerUin = Long.parseLong(this.k.a());
          paramMessageRecord = paramView.mId;
          Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "it.mId");
          this.j = paramMessageRecord;
          c();
          paramMessageRecord = this.k.j();
          if (paramMessageRecord != null) {
            paramMessageRecord.setText((CharSequence)new QQText((CharSequence)QzoneEmotionUtils.emCodesToQQcodes(paramView.mQuest), 3, 16));
          }
          paramMessageRecord = this.k.n();
          if (paramMessageRecord != null) {
            paramMessageRecord.setText((CharSequence)new QQText((CharSequence)QzoneEmotionUtils.emCodesToQQcodes(paramView.mAnswer), 3, 16));
          }
          paramMessageRecord = this.k.m();
          if (paramMessageRecord != null) {
            paramMessageRecord.setImageBitmap(a(this.k.a(), this.k.m()));
          }
          paramLinearLayout = this.k.p();
          if (paramLinearLayout != null)
          {
            paramMessageRecord = StringCompanionObject.INSTANCE;
            paramOnLongClickAndTouchListener = this.c.getString(2131896570);
            Intrinsics.checkExpressionValueIsNotNull(paramOnLongClickAndTouchListener, "mContext.getString(R.str…q_anonymous_browse_count)");
            Object[] arrayOfObject = new Object[1];
            if (paramView.mTotalViewCount > 0L) {
              paramMessageRecord = Utils.e((int)paramView.mTotalViewCount);
            } else {
              paramMessageRecord = Long.valueOf(paramView.mTotalViewCount);
            }
            arrayOfObject[0] = paramMessageRecord;
            paramMessageRecord = String.format(paramOnLongClickAndTouchListener, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
            Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "java.lang.String.format(format, *args)");
            paramLinearLayout.setText((CharSequence)paramMessageRecord);
          }
          if ((ThemeUtil.isSimpleDayTheme(false)) && (!ThemeUtil.isNowThemeIsNight((AppRuntime)this.a, false, null)))
          {
            paramMessageRecord = this.k.d();
            if (paramMessageRecord != null) {
              paramMessageRecord.setBackgroundResource(2130846283);
            }
            paramMessageRecord = this.k.l();
            if (paramMessageRecord != null) {
              paramMessageRecord.setBackgroundResource(2130846282);
            }
          }
          if (ThemeUtil.isInNightMode((AppRuntime)this.a))
          {
            paramMessageRecord = this.k.d();
            if (paramMessageRecord != null) {
              paramMessageRecord.setBackgroundResource(2130847379);
            }
            paramMessageRecord = this.k.l();
            if (paramMessageRecord != null) {
              paramMessageRecord.setBackgroundResource(2130847368);
            }
            paramMessageRecord = this.k.e();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130846256);
            }
            paramMessageRecord = this.k.f();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130846257);
            }
          }
          if (SimpleUIUtil.e())
          {
            paramMessageRecord = this.k.h();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130847385);
            }
            paramMessageRecord = this.k.g();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130847382);
            }
            paramMessageRecord = this.k.i();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130847384);
            }
            paramMessageRecord = this.k.k();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130847370);
            }
          }
          else
          {
            paramMessageRecord = this.k.h();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130847380);
            }
            paramMessageRecord = this.k.g();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130847381);
            }
            paramMessageRecord = this.k.i();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130847383);
            }
            paramMessageRecord = this.k.k();
            if (paramMessageRecord != null) {
              paramMessageRecord.setImageResource(2130847369);
            }
          }
          int n = this.f;
          int i1 = AnonymousConstant.HEAD_BG_COLOR.length;
          paramMessageRecord = this.k.g();
          if (paramMessageRecord != null) {
            paramMessageRecord.clearColorFilter();
          }
          paramMessageRecord = this.k.g();
          if (paramMessageRecord != null) {
            paramMessageRecord.setColorFilter(AnonymousConstant.HEAD_BG_COLOR[(n % i1)]);
          }
          boolean bool = paramView.mPraised;
          paramMessageRecord = this.k.q();
          if (paramMessageRecord == null) {
            Intrinsics.throwNpe();
          }
          paramLinearLayout = this.k.r();
          if (paramLinearLayout == null) {
            Intrinsics.throwNpe();
          }
          a(bool, paramMessageRecord, paramLinearLayout, paramView.mTotalPraiseCount);
          paramMessageRecord = this.k.s();
          if (paramMessageRecord != null) {
            paramMessageRecord.setText((CharSequence)Utils.e((int)paramView.mTotalCommentCount));
          }
          a(paramView, this.k);
          paramMessageRecord = this.a.getBusinessHandler(BusinessHandlerFactory.ANONYMOUS_ANSWER_HANDLER);
          if (paramMessageRecord != null)
          {
            paramMessageRecord = (AnonymousHandler)paramMessageRecord;
            if (!this.k.b())
            {
              this.k.a(true);
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
              ReportController.b(null, "dc00898", "", this.k.a(), "0X800B5C0", "0X800B5C0", 0, 0, "", "", "", "");
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
  
  @NotNull
  public QQCustomMenuItem[] a(@Nullable View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void b()
  {
    super.b();
    IFaceDecoder localIFaceDecoder = this.g;
    if (localIFaceDecoder != null)
    {
      if (localIFaceDecoder == null) {
        Intrinsics.throwNpe();
      }
      localIFaceDecoder.destory();
    }
    this.h.clear();
    this.a.removeObserver((BusinessObserver)this.m);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, @Nullable String paramString, @Nullable Bitmap paramBitmap)
  {
    paramString = (ImageView)((Map)this.h).get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAskAnonymouslyItemBuilder
 * JD-Core Version:    0.7.0.1
 */