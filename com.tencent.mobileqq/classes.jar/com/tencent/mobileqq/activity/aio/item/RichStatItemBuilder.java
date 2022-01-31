package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.IImageListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.RichStatus.StickerInfo;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.ImageItem;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import vbr;
import vbs;
import vbt;
import vbu;
import vbv;

public class RichStatItemBuilder
  extends AbstractChatItemBuilder
  implements IIconListener, IImageListener
{
  public static long a;
  private static RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  int jdField_a_of_type_Int;
  protected Handler a;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new vbt(this);
  AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = null;
  SignatureManager jdField_a_of_type_ComTencentMobileqqAppSignatureManager;
  MessageForRichState jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = null;
  public StatusManager a;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new vbv(this);
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  public HashMap a;
  private boolean jdField_a_of_type_Boolean = true;
  int b;
  public Handler b;
  private int c;
  
  RichStatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_c_of_type_Int = 4;
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)paramQQAppInterface.getManager(57));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    paramBaseAdapter = BaseApplicationImpl.getApplication();
    BaseApplication.getContext();
    ((WindowManager)paramBaseAdapter.getSystemService("window")).getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(183)).a(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "icon" + paramInt;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return paramString1 + "cover" + paramString2;
  }
  
  private void a(View paramView, RichStatItemBuilder.Holder paramHolder, MessageForRichState paramMessageForRichState)
  {
    if (jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    }
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId = paramMessageForRichState.feedId;
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId = paramMessageForRichState.tplId;
    paramView = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    if (TextUtils.isEmpty(paramMessageForRichState.actionId))
    {
      i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId;
      paramView.actionId = i;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = paramMessageForRichState.actionText;
      paramView = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (!TextUtils.isEmpty(paramMessageForRichState.dataId)) {
        break label260;
      }
      i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId;
      label97:
      paramView.dataId = i;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText = paramMessageForRichState.dataText;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = paramMessageForRichState.locText;
      paramView = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if (!TextUtils.isEmpty(paramMessageForRichState.locPos)) {
        break label272;
      }
    }
    label260:
    label272:
    for (int i = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationPosition;; i = Integer.parseInt(paramMessageForRichState.locPos))
    {
      paramView.locationPosition = i;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.time = paramMessageForRichState.time;
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = null;
      if ((paramMessageForRichState.plainText == null) || (paramMessageForRichState.plainText.length() <= 0)) {
        break label284;
      }
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = new ArrayList(paramMessageForRichState.plainText.length());
      i = 0;
      while (i < paramMessageForRichState.plainText.length())
      {
        jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.add(paramMessageForRichState.plainText.optString(i));
        i += 1;
      }
      i = Integer.parseInt(paramMessageForRichState.actionId);
      break;
      i = Integer.parseInt(paramMessageForRichState.dataId);
      break label97;
    }
    label284:
    jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos = paramMessageForRichState.mStickerInfos;
    paramHolder.jdField_c_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId;
    paramHolder.jdField_c_of_type_Int = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId;
    paramHolder.e = paramMessageForRichState.count;
    paramHolder.jdField_d_of_type_Int = paramMessageForRichState.zanFlag;
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_JavaLangCharSequence = jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getLocSS(this.jdField_a_of_type_AndroidContentContext.getResources(), paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_Float, TimeFormatterUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.time * 1000L) + "    ");
    b(paramHolder);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.time);
    if (!TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.feedsId))
    {
      this.jdField_a_of_type_Boolean = true;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_JavaLangString = String.valueOf(paramMessageForRichState.count);
      i = 8;
      if (paramMessageForRichState.zanFlag == 0) {
        i = 7;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a(paramHolder.jdField_c_of_type_Int, i, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 19.0F));
      if (paramView != null) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramView;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.invalidate();
      ThreadManager.post(new vbs(this, paramMessageForRichState), 8, null, true);
      return;
      this.jdField_a_of_type_Boolean = false;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_JavaLangString = String.valueOf(paramMessageForRichState.count);
    }
  }
  
  private void b(RichStatItemBuilder.Holder paramHolder)
  {
    Object localObject1 = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_JavaLangCharSequence = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), paramHolder, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_c_of_type_Int = Color.parseColor("#ffa8a8a8");
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo == null) {}
    do
    {
      return;
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem == null) {
        break;
      }
      this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Int / paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.jdField_a_of_type_Int * paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.jdField_b_of_type_Int));
      i = 17;
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.setSigViewSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      localObject1 = ((SignatureManager)localObject1).a(jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId, i, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    } while (localObject1 == null);
    Object localObject2;
    if ((localObject1 instanceof URLDrawable))
    {
      localObject2 = (URLDrawable)localObject1;
      if (((URLDrawable)localObject2).getStatus() == 1)
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_JavaLangCharSequence = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), paramHolder, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        if (!TextUtils.isEmpty(paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.p)) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_c_of_type_Int = Color.parseColor(paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.p);
        }
      }
      ((URLDrawable)localObject2).setURLDrawableListener(new vbu(this, paramHolder));
      label258:
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
      if ((SignatureManager.e == null) || (SignatureManager.a == null)) {
        break label662;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.setAnimation(paramHolder.jdField_c_of_type_Int, SignatureManager.e, SignatureManager.a);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_d_of_type_Boolean = true;
      return;
      localObject2 = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_Int);
      if (localObject2 == null) {
        break label685;
      }
    }
    label395:
    label662:
    label679:
    label685:
    for (int i = ((Layout)localObject2).getLineCount();; i = 1)
    {
      float f;
      if (i < 3)
      {
        f = 0.35F;
        i = 2;
        label365:
        if ((localObject2 != null) && (!TextUtils.isEmpty(paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.s))) {
          break label570;
        }
        this.jdField_b_of_type_Int = ((int)(f * this.jdField_a_of_type_Int));
        if ((localObject2 != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.jdField_a_of_type_JavaLangString.equals("0"))) {
          this.jdField_b_of_type_Int = (((Layout)localObject2).getHeight() + DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 75.0F));
        }
        if (localObject2 == null) {
          break label679;
        }
      }
      for (int j = ((Layout)localObject2).getHeight() + DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 84.0F);; j = 0)
      {
        if (j > this.jdField_b_of_type_Int) {
          this.jdField_b_of_type_Int = j;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SignatureView", 2, "mBgWidth: " + this.jdField_a_of_type_Int + " mBgHeight: " + this.jdField_b_of_type_Int);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.setSigViewSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        break;
        if (i < 5)
        {
          f = 0.46F;
          i = 3;
          break label365;
        }
        i = 4;
        f = 0.577F;
        break label365;
        label570:
        this.jdField_b_of_type_Int = (((Layout)localObject2).getHeight() + DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 75.0F));
        break label395;
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_JavaLangCharSequence = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), paramHolder, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        if (TextUtils.isEmpty(paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.p)) {
          break label258;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_c_of_type_Int = Color.parseColor(paramHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo.p);
        break label258;
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_d_of_type_Boolean = false;
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_c_of_type_Boolean = false;
        return;
      }
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = ((MessageForRichState)paramMessageRecord);
    jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.uniseq;
    paramLinearLayout = (RichStatItemBuilder.Holder)paramViewHolder;
    paramMessageRecord = paramView;
    int i;
    int j;
    int k;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SignatureView", 2, "convertView is null, create SignatureView.");
      }
      paramMessageRecord = new SignatureView(this.jdField_a_of_type_AndroidContentContext);
      paramMessageRecord.setEnabled(true);
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView = ((SignatureView)paramMessageRecord);
      i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
      j = Math.min(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().widthPixels, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().heightPixels);
      k = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), 38.0F);
      int m = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 260.0F);
      if (i >= m) {
        this.jdField_a_of_type_Int = m;
      }
    }
    else
    {
      if (jdField_b_of_type_Boolean)
      {
        if (paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder == null) {
          paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        }
        paramMessageRecord.setContentDescription(null);
        paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.length(), "");
      }
      paramViewHolder = ((SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57)).a(Integer.toString(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.tplId));
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo = paramViewHolder;
      if ((paramViewHolder == null) || (paramViewHolder.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem == null)) {
        break label997;
      }
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_Boolean = false;
      label265:
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.setOnTouchListener(new vbr(this, paramLinearLayout));
      paramLinearLayout.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.uniseq;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a != null) {
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a.getDefaultColor();
      }
      paramLinearLayout.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.frienduin;
      paramLinearLayout.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.istroop;
      paramLinearLayout.jdField_b_of_type_JavaLangString = null;
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.ver;
      if ((paramViewHolder != null) && (paramViewHolder.equals("1.0"))) {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time <= 0L) {
          break label1189;
        }
      }
    }
    label1034:
    label1171:
    label1189:
    for (paramViewHolder = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time * 1000L);; paramViewHolder = null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedNum != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedNum.trim().length() > 0))
      {
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.feedNum;
        label466:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d == null) {
          break label1023;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        label484:
        paramView = Utils.b(paramView, 10);
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_JavaLangString = (paramView + "更新了签名");
        i = Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a(Integer.toString(paramLinearLayout.jdField_c_of_type_Int)).e);
        paramOnLongClickAndTouchListener = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionText, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataText, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.locText, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.locPos, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.plainText, i);
        if (jdField_b_of_type_Boolean)
        {
          paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.append(paramView);
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time > 0L) {
            paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.append("于").append(paramViewHolder);
          }
          paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.append("更新了签名，内容是：").append(paramOnLongClickAndTouchListener);
          paramMessageRecord.setContentDescription(paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.toString());
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataText == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataText.length() <= 0)) {
          break label1034;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId.trim().length() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId = "0";
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataId == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataId.trim().length() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataId = "0";
        }
        paramViewHolder = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataId);
        if (QLog.isColorLevel()) {
          QLog.d("AIOSign", 2, "taskKey is:" + paramViewHolder);
        }
        paramLinearLayout.jdField_b_of_type_JavaLangString = paramViewHolder;
        label810:
        a(paramMessageRecord, paramLinearLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState);
        paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.mStickerInfos;
        if (!SignatureManager.jdField_b_of_type_Boolean) {
          break label1171;
        }
        if ((paramViewHolder != null) && (paramViewHolder.size() > 0))
        {
          paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_JavaUtilList = paramViewHolder;
          paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_JavaUtilList = a(paramLinearLayout, paramViewHolder);
          if ((paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_JavaUtilList != null) && (paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_JavaUtilList.size() > 0) && (paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_JavaUtilList != null) && (paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_JavaUtilList.size() > 0) && (paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_JavaUtilList.size() == paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_JavaUtilList.size()))
          {
            paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.e = true;
            paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_d_of_type_Int = paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_JavaUtilList.size();
          }
        }
      }
      label997:
      label1023:
      while (!QLog.isColorLevel())
      {
        return paramMessageRecord;
        this.jdField_a_of_type_Int = (j - k);
        break;
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_Boolean = true;
        break label265;
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_JavaLangString = "0";
        break label466;
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        break label484;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionText != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionText.length() > 0))
        {
          paramViewHolder = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionId, 201);
          if (QLog.isColorLevel()) {
            QLog.d("AIOSign", 2, "taskKey is:" + paramViewHolder);
          }
          paramLinearLayout.jdField_b_of_type_JavaLangString = paramViewHolder;
          break label810;
        }
        if (!QLog.isColorLevel()) {
          break label810;
        }
        QLog.e("AIOSign", 2, "bindViewForRichSignature(),dataText is:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.dataText + ",actionText is:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.actionText);
        break label810;
      }
      QLog.d("DiySignature", 2, "getBubbleView diy signature not enable");
      return paramMessageRecord;
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new RichStatItemBuilder.Holder();
  }
  
  CharSequence a(String paramString1, String paramString2, String paramString3, String paramString4, JSONArray paramJSONArray, int paramInt)
  {
    paramString3 = this.jdField_a_of_type_JavaLangStringBuilder;
    paramString3.setLength(0);
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      paramString3.append(paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      paramString3.append(paramString2);
    }
    int j = Integer.parseInt(paramString4);
    int i;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      i = 0;
      while (i < j)
      {
        paramString4 = paramJSONArray.optString(i);
        if ((paramString4 != null) && (paramString4.length() > 0)) {
          paramString3.append(paramString4);
        }
        i += 1;
      }
    }
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      int k = paramJSONArray.length();
      i = j;
      while (i < k)
      {
        paramString4 = paramJSONArray.optString(i);
        if ((paramString4 != null) && (paramString4.length() > 0)) {
          paramString3.append(paramString4);
        }
        i += 1;
      }
    }
    paramString4 = new SpannableString(paramString3.toString());
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        paramInt = paramString1.length() + paramString2.length();
        paramString4.setSpan(new ForegroundColorSpan(-16754769), 0, paramInt, 33);
      }
    }
    for (;;)
    {
      paramString3.setLength(0);
      return paramString4;
      paramInt = paramString2.length();
      break;
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        paramString4.setSpan(new ForegroundColorSpan(paramInt), 0, paramString1.length(), 33);
      }
    }
  }
  
  public List a(RichStatItemBuilder.Holder paramHolder, ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      RichStatus.StickerInfo localStickerInfo = (RichStatus.StickerInfo)localIterator.next();
      paramArrayList = AppConstants.by + localStickerInfo.jdField_a_of_type_Int + ".png";
      Object localObject = new Bundle();
      int i = (int)(this.jdField_a_of_type_Int * localStickerInfo.c);
      int j = (int)(this.jdField_b_of_type_Int * localStickerInfo.d);
      ((Bundle)localObject).putInt("key_width", i);
      ((Bundle)localObject).putInt("key_height", j);
      ((Bundle)localObject).putInt("key_loop", this.jdField_c_of_type_Int);
      ((Bundle)localObject).putLong("bundle_key_bid", 9L);
      ((Bundle)localObject).putString("bundle_key_scid", "signature.sticker." + localStickerInfo.jdField_a_of_type_Int + ".png");
      URLDrawable localURLDrawable = VasApngUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, "-SignatureSticker-", null, new int[] { 0 }, "-SignatureSticker-", (Bundle)localObject);
      if (localURLDrawable != null)
      {
        localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localStickerInfo.jdField_a_of_type_Int));
        paramArrayList = (ArrayList)localObject;
        if (localObject == null) {
          paramArrayList = new ArrayList();
        }
        localURLDrawable.setCallback(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView);
        paramArrayList.add(localURLDrawable);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localStickerInfo.jdField_a_of_type_Int), paramArrayList);
        localArrayList.add(localURLDrawable);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    }
    ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183)).b(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager = null;
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void a(RichStatItemBuilder.Holder paramHolder)
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext)) {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, ((Resources)localObject).getString(2131432992), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
      }
    }
    else
    {
      return;
    }
    if (Math.abs(System.currentTimeMillis() - 0L) < 200L)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, ((Resources)localObject).getString(2131437866), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
      return;
    }
    try
    {
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_JavaLangString == null) {}
      int j;
      int k;
      for (localObject = "0";; localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_JavaLangString.toString())
      {
        j = Integer.parseInt((String)localObject);
        if (paramHolder.jdField_d_of_type_Int != 0) {
          break;
        }
        paramHolder.jdField_d_of_type_Int = 1;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "aio_act_on", 0, 0, "", "", "", "");
        i = 8;
        j += 1;
        k = 1;
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_JavaLangString = (j + "");
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a(paramHolder.jdField_c_of_type_Int, i, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 19.0F));
        if (localObject != null) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
        }
        localObject = (SignatureHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(41);
        if (localObject != null) {
          ((SignatureHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, 255, k);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.invalidate();
        return;
      }
      paramHolder.jdField_d_of_type_Int = 0;
      int i = j - 1;
      if (i > 0) {}
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "aio_act_off", 0, 0, "", "", "", "");
        int m = 7;
        j = i;
        k = 0;
        i = m;
        break;
        i = 0;
      }
      return;
    }
    catch (Exception paramHolder) {}
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder
 * JD-Core Version:    0.7.0.1
 */