package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public abstract class TroopGiftMsgItemBuilder
  extends BaseBubbleBuilder
{
  private static int jdField_a_of_type_Int = 101;
  public static String a;
  public static List<MessageForTroopGift> a;
  private static int d = 102;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  Handler jdField_b_of_type_AndroidOsHandler = new TroopGiftMsgItemBuilder.1(this);
  Map<String, ArrayList<Runnable>> jdField_b_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilList = new LinkedList();
    jdField_a_of_type_JavaLangString = "TroopGiftMsgItemBuilder";
  }
  
  public TroopGiftMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  @NotNull
  private Bitmap a(Bitmap paramBitmap, BubbleImageView paramBubbleImageView, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDisplayMetrics();
    Object localObject2 = new Matrix();
    ((Matrix)localObject2).postScale(1.0F, 1.0F);
    int m = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    double d1 = m;
    Double.isNaN(d1);
    int j = (int)(d1 * 0.357D);
    d1 = i;
    Double.isNaN(d1);
    int k = (int)(d1 * 0.357D);
    d1 = m - 1;
    Double.isNaN(d1);
    m = (int)(d1 * 0.642D);
    d1 = i - 1;
    Double.isNaN(d1);
    paramBitmap = Bitmap.createBitmap(paramBitmap, j, k, m, (int)(d1 * 0.642D), (Matrix)localObject2, true);
    i = paramBubbleImageView.getLayoutParams().width;
    j = (int)(((DisplayMetrics)localObject1).density * 150.0F);
    paramBubbleImageView = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
    localObject2 = new Canvas(paramBubbleImageView);
    localObject1 = new Paint();
    ((Paint)localObject1).setColor(-1);
    ((Canvas)localObject2).drawRect(0.0F, 0.0F, i, j, (Paint)localObject1);
    if (paramInt != 0)
    {
      localObject2 = new Canvas(paramBubbleImageView);
      ((Canvas)localObject2).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(0, 0, i, j), (Paint)localObject1);
      ((Paint)localObject1).setColor(paramInt);
      ((Canvas)localObject2).drawRect(0.0F, 0.0F, paramBubbleImageView.getWidth(), paramBubbleImageView.getHeight(), (Paint)localObject1);
      StackBlur.a(paramBubbleImageView, 60);
    }
    return paramBubbleImageView;
  }
  
  @NotNull
  private MessageForTroopGift a(MessageForTroopGift paramMessageForTroopGift, TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder)
  {
    boolean bool = AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (paramMessageForTroopGift.senderUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
    {
      if (paramMessageForTroopGift.receiverUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
      {
        paramTroopGiftMsgHolder.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        paramTroopGiftMsgHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        paramTroopGiftMsgHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      else
      {
        paramTroopGiftMsgHolder.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        paramTroopGiftMsgHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        paramTroopGiftMsgHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    else
    {
      paramTroopGiftMsgHolder.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      paramTroopGiftMsgHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      paramTroopGiftMsgHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if ((paramMessageForTroopGift.btFlag == 0) || (bool))
    {
      paramTroopGiftMsgHolder.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      paramTroopGiftMsgHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (paramMessageForTroopGift.btFlag == 1) {
      paramTroopGiftMsgHolder.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (paramMessageForTroopGift.btFlag == 2) {
      paramTroopGiftMsgHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (((paramMessageForTroopGift.receiverUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) || (paramMessageForTroopGift.senderUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) || ((paramMessageForTroopGift.receiverUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) && (paramMessageForTroopGift.btFlag == 0))) && (paramMessageForTroopGift.is_activity_gift == 1) && (!TextUtils.isEmpty(paramMessageForTroopGift.activity_text)) && (!TextUtils.isEmpty(paramMessageForTroopGift.activity_text_color)) && (!TextUtils.isEmpty(paramMessageForTroopGift.activity_url)))
    {
      paramTroopGiftMsgHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      paramTroopGiftMsgHolder.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      paramTroopGiftMsgHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      paramTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetButton.setText(paramMessageForTroopGift.activity_text);
      paramTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor(paramMessageForTroopGift.activity_text_color));
    }
    return paramMessageForTroopGift;
  }
  
  private void a(TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder)
  {
    if (((paramTroopGiftMsgHolder.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 8) && (paramTroopGiftMsgHolder.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 8) && (paramTroopGiftMsgHolder.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8)) || (this.jdField_b_of_type_Boolean)) {
      paramTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams().height = ((int)(this.jdField_a_of_type_Float * 100.0F));
    } else {
      paramTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams().height = ((int)(this.jdField_a_of_type_Float * 142.0F));
    }
    if (this.jdField_b_of_type_Boolean)
    {
      paramTroopGiftMsgHolder.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      paramTroopGiftMsgHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      paramTroopGiftMsgHolder.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  private void a(TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder, MessageForTroopGift paramMessageForTroopGift)
  {
    if ((AppSetting.d) && (!TextUtils.isEmpty(paramMessageForTroopGift.title)))
    {
      String str = paramMessageForTroopGift.title;
      paramMessageForTroopGift = str;
      if (paramTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        paramMessageForTroopGift = str;
        if (!TextUtils.isEmpty(paramTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetTextView.getText()))
        {
          paramMessageForTroopGift = new StringBuilder();
          paramMessageForTroopGift.append(str);
          paramMessageForTroopGift.append(paramTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
          paramMessageForTroopGift = paramMessageForTroopGift.toString();
        }
      }
      paramTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramMessageForTroopGift);
    }
  }
  
  private void a(TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder, MessageForTroopGift paramMessageForTroopGift, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getStatus() == 2))
    {
      paramURLDrawable.restartDownload();
      return;
    }
    if (paramURLDrawable != null) {
      if ((paramURLDrawable.getCurrDrawable() instanceof RegionDrawable))
      {
        int j = paramMessageForTroopGift.objColor;
        int i = j;
        if (j == 0) {
          i = -2138570752;
        }
        if (TextUtils.isEmpty(paramMessageForTroopGift.interactId))
        {
          paramURLDrawable = ((RegionDrawable)paramURLDrawable.getCurrDrawable()).getBitmap();
          paramTroopGiftMsgHolder = paramTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramMessageForTroopGift.giftPicId);
          localStringBuilder.append("");
          a(paramURLDrawable, i, paramTroopGiftMsgHolder, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramTroopGiftMsgHolder = new StringBuilder();
        paramTroopGiftMsgHolder.append("drawable.getCurrDrawable() instanceof  RegionDrawable = ");
        paramTroopGiftMsgHolder.append(paramURLDrawable.getCurrDrawable() instanceof RegionDrawable);
        QLog.e("TroopGiftMsgItemBuilder", 2, paramTroopGiftMsgHolder.toString());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty()) {
      ThreadManager.post(new TroopGiftMsgItemBuilder.8(paramQQAppInterface.getEntityManagerFactory().createEntityManager()), 5, null, true);
    }
  }
  
  private void a(MessageForTroopGift paramMessageForTroopGift)
  {
    if (!paramMessageForTroopGift.isReported)
    {
      int j = 1;
      paramMessageForTroopGift.isReported = true;
      jdField_a_of_type_JavaUtilList.add(paramMessageForTroopGift);
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(paramMessageForTroopGift.senderuin)) {
        i = 0;
      } else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(Long.valueOf(paramMessageForTroopGift.receiverUin))) {
        i = 1;
      } else {
        i = 2;
      }
      if (paramMessageForTroopGift.istroop == 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "exp_obj", 0, 0, "", "", "", "");
        return;
      }
      if (paramMessageForTroopGift.istroop == 3000)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "exp_obj", 0, 0, "", "", "", "");
        return;
      }
      if ((paramMessageForTroopGift.istroop != 1000) && (paramMessageForTroopGift.istroop != 1004))
      {
        Object localObject1;
        Object localObject2;
        if (paramMessageForTroopGift.isFromNearby)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("");
          NearbyFlowerManager.a("gift_aio", "exp_obj", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
          if (TroopGiftUtil.a(paramMessageForTroopGift))
          {
            paramMessageForTroopGift = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("");
            NearbyFlowerManager.a("gift_aio", "exp_play", paramMessageForTroopGift, ((StringBuilder)localObject1).toString(), "", "");
          }
        }
        else
        {
          if (AnonymousChatHelper.a(paramMessageForTroopGift)) {
            j = 2;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append("");
          localObject3 = ((StringBuilder)localObject3).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramMessageForTroopGift.giftPicId);
          localStringBuilder.append("");
          ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_obj", j, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), "");
          if (TroopGiftUtil.a(paramMessageForTroopGift))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append("");
            localObject3 = ((StringBuilder)localObject3).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramMessageForTroopGift.giftPicId);
            localStringBuilder.append("");
            ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_play", j, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), "");
          }
        }
      }
      else
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "exp_obj", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(BubbleImageView paramBubbleImageView, int paramInt, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(paramInt);
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(paramInt);
    paramBubbleImageView.setImageDrawable(URLDrawable.getDrawable(new File(a(paramString, paramInt)), localURLDrawableOptions));
  }
  
  private void a(BubbleImageView paramBubbleImageView, String paramString, int paramInt)
  {
    if (paramBubbleImageView.getTag(2131373865).equals(paramString)) {
      a(paramBubbleImageView, paramInt, paramString);
    }
  }
  
  /* Error */
  private void a(String paramString1, int paramInt, Bitmap paramBitmap, BubbleImageView paramBubbleImageView, String paramString2, SharedPreferences paramSharedPreferences, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +45 -> 48
    //   6: new 290	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   13: astore 9
    //   15: aload 9
    //   17: ldc_w 511
    //   20: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 9
    //   26: aload_0
    //   27: aload_1
    //   28: iload_2
    //   29: invokevirtual 484	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   32: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: ldc_w 513
    //   39: iconst_2
    //   40: aload 9
    //   42: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 516	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: aload_0
    //   50: aload_3
    //   51: aload 4
    //   53: iload_2
    //   54: invokespecial 518	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:a	(Landroid/graphics/Bitmap;Lcom/tencent/mobileqq/widget/BubbleImageView;I)Landroid/graphics/Bitmap;
    //   57: aload_1
    //   58: iload_2
    //   59: aload 5
    //   61: invokespecial 521	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:a	(Landroid/graphics/Bitmap;Ljava/lang/String;ILjava/lang/String;)Z
    //   64: ifeq +33 -> 97
    //   67: aload 6
    //   69: invokeinterface 527 1 0
    //   74: aload 5
    //   76: lload 7
    //   78: invokeinterface 533 4 0
    //   83: pop
    //   84: aload 6
    //   86: invokeinterface 527 1 0
    //   91: invokeinterface 536 1 0
    //   96: pop
    //   97: getstatic 538	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   100: new 540	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$4
    //   103: dup
    //   104: aload_0
    //   105: aload 5
    //   107: aload 4
    //   109: aload_1
    //   110: iload_2
    //   111: invokespecial 543	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$4:<init>	(Lcom/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder;Ljava/lang/String;Lcom/tencent/mobileqq/widget/BubbleImageView;Ljava/lang/String;I)V
    //   114: invokevirtual 548	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   117: pop
    //   118: goto +104 -> 222
    //   121: astore_1
    //   122: goto +117 -> 239
    //   125: astore_1
    //   126: aload 6
    //   128: invokeinterface 527 1 0
    //   133: aload 5
    //   135: lconst_0
    //   136: invokeinterface 533 4 0
    //   141: pop
    //   142: aload 6
    //   144: invokeinterface 527 1 0
    //   149: invokeinterface 536 1 0
    //   154: pop
    //   155: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +64 -> 222
    //   161: ldc_w 550
    //   164: iconst_2
    //   165: aload_1
    //   166: invokevirtual 553	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   169: invokestatic 555	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: goto +50 -> 222
    //   175: astore_1
    //   176: aload 6
    //   178: invokeinterface 527 1 0
    //   183: aload 5
    //   185: lconst_0
    //   186: invokeinterface 533 4 0
    //   191: pop
    //   192: aload 6
    //   194: invokeinterface 527 1 0
    //   199: invokeinterface 536 1 0
    //   204: pop
    //   205: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +14 -> 222
    //   211: ldc_w 550
    //   214: iconst_2
    //   215: aload_1
    //   216: invokevirtual 556	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   219: invokestatic 555	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_0
    //   223: getfield 58	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   226: aload 5
    //   228: iconst_0
    //   229: invokestatic 561	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   232: invokeinterface 567 3 0
    //   237: pop
    //   238: return
    //   239: aload_0
    //   240: getfield 58	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   243: aload 5
    //   245: iconst_0
    //   246: invokestatic 561	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   249: invokeinterface 567 3 0
    //   254: pop
    //   255: aload_1
    //   256: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	TroopGiftMsgItemBuilder
    //   0	257	1	paramString1	String
    //   0	257	2	paramInt	int
    //   0	257	3	paramBitmap	Bitmap
    //   0	257	4	paramBubbleImageView	BubbleImageView
    //   0	257	5	paramString2	String
    //   0	257	6	paramSharedPreferences	SharedPreferences
    //   0	257	7	paramLong	long
    //   13	28	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	48	121	finally
    //   48	97	121	finally
    //   97	118	121	finally
    //   126	172	121	finally
    //   176	222	121	finally
    //   0	48	125	java/lang/OutOfMemoryError
    //   48	97	125	java/lang/OutOfMemoryError
    //   97	118	125	java/lang/OutOfMemoryError
    //   0	48	175	java/lang/Exception
    //   48	97	175	java/lang/Exception
    //   97	118	175	java/lang/Exception
  }
  
  /* Error */
  private boolean a(Bitmap paramBitmap, String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 290	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: getstatic 574	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   14: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 7
    //   20: ldc_w 576
    //   23: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: new 481	java/io/File
    //   30: dup
    //   31: aload 7
    //   33: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 582	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   39: invokespecial 487	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 585	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: new 481	java/io/File
    //   49: dup
    //   50: aload_0
    //   51: aload_2
    //   52: iload_3
    //   53: invokevirtual 484	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   56: invokespecial 487	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore 10
    //   61: aload 10
    //   63: invokevirtual 588	java/io/File:exists	()Z
    //   66: ifne +17 -> 83
    //   69: aload 10
    //   71: invokevirtual 591	java/io/File:createNewFile	()Z
    //   74: pop
    //   75: goto +8 -> 83
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 594	java/io/IOException:printStackTrace	()V
    //   83: aconst_null
    //   84: astore 8
    //   86: aconst_null
    //   87: astore 9
    //   89: aconst_null
    //   90: astore_2
    //   91: new 596	java/io/BufferedOutputStream
    //   94: dup
    //   95: new 598	java/io/FileOutputStream
    //   98: dup
    //   99: aload 10
    //   101: invokespecial 601	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   104: sipush 8192
    //   107: invokespecial 604	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   110: astore 7
    //   112: aload_1
    //   113: getstatic 610	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   116: bipush 100
    //   118: aload 7
    //   120: invokevirtual 614	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   123: istore 6
    //   125: aload_0
    //   126: getfield 58	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   129: aload 4
    //   131: iconst_0
    //   132: invokestatic 561	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   135: invokeinterface 567 3 0
    //   140: pop
    //   141: aload 7
    //   143: invokevirtual 617	java/io/BufferedOutputStream:close	()V
    //   146: iload 6
    //   148: istore 5
    //   150: goto +301 -> 451
    //   153: astore_1
    //   154: iload 6
    //   156: istore 5
    //   158: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +290 -> 451
    //   164: ldc_w 550
    //   167: iconst_2
    //   168: aload_1
    //   169: invokevirtual 618	java/io/IOException:getMessage	()Ljava/lang/String;
    //   172: invokestatic 555	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: iload 6
    //   177: istore 5
    //   179: goto +272 -> 451
    //   182: astore_1
    //   183: aload 7
    //   185: astore_2
    //   186: goto +326 -> 512
    //   189: astore_2
    //   190: aload 7
    //   192: astore_1
    //   193: aload_2
    //   194: astore 7
    //   196: goto +22 -> 218
    //   199: astore_2
    //   200: aload 7
    //   202: astore_1
    //   203: aload_2
    //   204: astore 7
    //   206: goto +135 -> 341
    //   209: astore_1
    //   210: goto +302 -> 512
    //   213: astore 7
    //   215: aload 8
    //   217: astore_1
    //   218: aload_1
    //   219: astore_2
    //   220: aload_0
    //   221: getfield 621	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   224: getstatic 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   227: iconst_0
    //   228: invokevirtual 627	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   231: astore 8
    //   233: aload_1
    //   234: astore_2
    //   235: aload 8
    //   237: invokeinterface 527 1 0
    //   242: aload 4
    //   244: lconst_0
    //   245: invokeinterface 533 4 0
    //   250: pop
    //   251: aload_1
    //   252: astore_2
    //   253: aload 8
    //   255: invokeinterface 527 1 0
    //   260: invokeinterface 536 1 0
    //   265: pop
    //   266: aload_1
    //   267: astore_2
    //   268: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +17 -> 288
    //   274: aload_1
    //   275: astore_2
    //   276: ldc_w 550
    //   279: iconst_2
    //   280: aload 7
    //   282: invokevirtual 553	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   285: invokestatic 555	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload_0
    //   289: getfield 58	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   292: aload 4
    //   294: iconst_0
    //   295: invokestatic 561	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   298: invokeinterface 567 3 0
    //   303: pop
    //   304: aload_1
    //   305: ifnull +143 -> 448
    //   308: aload_1
    //   309: invokevirtual 617	java/io/BufferedOutputStream:close	()V
    //   312: goto +136 -> 448
    //   315: astore_1
    //   316: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +129 -> 448
    //   322: ldc_w 550
    //   325: iconst_2
    //   326: aload_1
    //   327: invokevirtual 618	java/io/IOException:getMessage	()Ljava/lang/String;
    //   330: invokestatic 555	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: goto +115 -> 448
    //   336: astore 7
    //   338: aload 9
    //   340: astore_1
    //   341: aload_1
    //   342: astore_2
    //   343: aload_0
    //   344: getfield 621	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   347: getstatic 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   350: iconst_0
    //   351: invokevirtual 627	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   354: astore 8
    //   356: aload_1
    //   357: astore_2
    //   358: aload 8
    //   360: invokeinterface 527 1 0
    //   365: aload 4
    //   367: lconst_0
    //   368: invokeinterface 533 4 0
    //   373: pop
    //   374: aload_1
    //   375: astore_2
    //   376: aload 8
    //   378: invokeinterface 527 1 0
    //   383: invokeinterface 536 1 0
    //   388: pop
    //   389: aload_1
    //   390: astore_2
    //   391: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +17 -> 411
    //   397: aload_1
    //   398: astore_2
    //   399: ldc_w 550
    //   402: iconst_2
    //   403: aload 7
    //   405: invokevirtual 556	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   408: invokestatic 555	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload_0
    //   412: getfield 58	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   415: aload 4
    //   417: iconst_0
    //   418: invokestatic 561	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   421: invokeinterface 567 3 0
    //   426: pop
    //   427: aload_1
    //   428: ifnull +20 -> 448
    //   431: aload_1
    //   432: invokevirtual 617	java/io/BufferedOutputStream:close	()V
    //   435: goto +13 -> 448
    //   438: astore_1
    //   439: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +6 -> 448
    //   445: goto -123 -> 322
    //   448: iconst_0
    //   449: istore 5
    //   451: iload 5
    //   453: ifne +56 -> 509
    //   456: aload 10
    //   458: invokevirtual 588	java/io/File:exists	()Z
    //   461: ifeq +48 -> 509
    //   464: aload 10
    //   466: invokevirtual 630	java/io/File:delete	()Z
    //   469: pop
    //   470: aload_0
    //   471: getfield 621	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   474: getstatic 30	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   477: iconst_0
    //   478: invokevirtual 627	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   481: astore_1
    //   482: aload_1
    //   483: invokeinterface 527 1 0
    //   488: aload 4
    //   490: lconst_0
    //   491: invokeinterface 533 4 0
    //   496: pop
    //   497: aload_1
    //   498: invokeinterface 527 1 0
    //   503: invokeinterface 536 1 0
    //   508: pop
    //   509: iload 5
    //   511: ireturn
    //   512: aload_0
    //   513: getfield 58	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   516: aload 4
    //   518: iconst_0
    //   519: invokestatic 561	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   522: invokeinterface 567 3 0
    //   527: pop
    //   528: aload_2
    //   529: ifnull +28 -> 557
    //   532: aload_2
    //   533: invokevirtual 617	java/io/BufferedOutputStream:close	()V
    //   536: goto +21 -> 557
    //   539: astore_2
    //   540: invokestatic 348	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq +14 -> 557
    //   546: ldc_w 550
    //   549: iconst_2
    //   550: aload_2
    //   551: invokevirtual 618	java/io/IOException:getMessage	()Ljava/lang/String;
    //   554: invokestatic 555	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: goto +5 -> 562
    //   560: aload_1
    //   561: athrow
    //   562: goto -2 -> 560
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	this	TroopGiftMsgItemBuilder
    //   0	565	1	paramBitmap	Bitmap
    //   0	565	2	paramString1	String
    //   0	565	3	paramInt	int
    //   0	565	4	paramString2	String
    //   148	362	5	bool1	boolean
    //   123	53	6	bool2	boolean
    //   7	198	7	localObject1	Object
    //   213	68	7	localOutOfMemoryError	OutOfMemoryError
    //   336	68	7	localException	Exception
    //   84	293	8	localSharedPreferences	SharedPreferences
    //   87	252	9	localObject2	Object
    //   59	406	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   69	75	78	java/io/IOException
    //   141	146	153	java/io/IOException
    //   112	125	182	finally
    //   112	125	189	java/lang/OutOfMemoryError
    //   112	125	199	java/lang/Exception
    //   91	112	209	finally
    //   220	233	209	finally
    //   235	251	209	finally
    //   253	266	209	finally
    //   268	274	209	finally
    //   276	288	209	finally
    //   343	356	209	finally
    //   358	374	209	finally
    //   376	389	209	finally
    //   391	397	209	finally
    //   399	411	209	finally
    //   91	112	213	java/lang/OutOfMemoryError
    //   308	312	315	java/io/IOException
    //   91	112	336	java/lang/Exception
    //   431	435	438	java/io/IOException
    //   532	536	539	java/io/IOException
  }
  
  private void b(TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder, MessageForTroopGift paramMessageForTroopGift)
  {
    Object localObject;
    if (paramTroopGiftMsgHolder.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      localObject = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_tks").a(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageForTroopGift.frienduin);
      localStringBuilder.append("");
      ((ReportTask)localObject).a(new String[] { localStringBuilder.toString(), "" }).a();
      localObject = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_return").a(0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageForTroopGift.frienduin);
      localStringBuilder.append("");
      ((ReportTask)localObject).a(new String[] { localStringBuilder.toString(), "" }).a();
    }
    if (paramTroopGiftMsgHolder.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      paramTroopGiftMsgHolder = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_ask").a(0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramMessageForTroopGift.frienduin);
      ((StringBuilder)localObject).append("");
      paramTroopGiftMsgHolder.a(new String[] { ((StringBuilder)localObject).toString(), "" }).a();
    }
  }
  
  private void c(TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder, MessageForTroopGift paramMessageForTroopGift)
  {
    if (TextUtils.isEmpty(paramMessageForTroopGift.charmHeroism)) {
      return;
    }
    paramTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    Object localObject = paramMessageForTroopGift.charmHeroism.replace("<", "").replace(">", "").split("\\$s");
    if ((localObject != null) && (localObject.length == 2))
    {
      String[] arrayOfString1 = localObject[0].split("\\#");
      if ((arrayOfString1 != null) && (arrayOfString1.length == 3))
      {
        String[] arrayOfString2 = localObject[1].split("\\#");
        if ((arrayOfString2 != null) && (arrayOfString2.length == 3))
        {
          long l1 = paramMessageForTroopGift.senderUin;
          long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
          localObject = "+";
          StringBuilder localStringBuilder;
          if (l1 == l2)
          {
            if (paramMessageForTroopGift.sendScore < 0) {
              localObject = "";
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(2131715190));
            localStringBuilder.append(arrayOfString1[0]);
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(paramMessageForTroopGift.sendScore);
            localStringBuilder.append("");
            localStringBuilder.append(arrayOfString2[0]);
            localObject = localStringBuilder.toString();
            if (paramMessageForTroopGift.sendScore != 0) {}
          }
          else
          {
            do
            {
              for (;;)
              {
                localObject = "";
                break label455;
                if (paramMessageForTroopGift.receiverUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
                  break;
                }
                if (paramMessageForTroopGift.recvScore < 0) {
                  localObject = "";
                }
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(HardCodeUtil.a(2131715174));
                localStringBuilder.append(arrayOfString1[1]);
                localStringBuilder.append((String)localObject);
                localStringBuilder.append(paramMessageForTroopGift.recvScore);
                localStringBuilder.append("");
                localStringBuilder.append(arrayOfString2[1]);
                localObject = localStringBuilder.toString();
                if (paramMessageForTroopGift.recvScore != 0) {
                  break label455;
                }
              }
              if (paramMessageForTroopGift.recvScore < 0) {
                localObject = "";
              }
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(HardCodeUtil.a(2131715189));
              localStringBuilder.append(arrayOfString1[2]);
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(paramMessageForTroopGift.recvScore);
              localStringBuilder.append("");
              localStringBuilder.append(arrayOfString2[2]);
              localObject = localStringBuilder.toString();
            } while (paramMessageForTroopGift.recvScore == 0);
          }
          label455:
          paramTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
      }
    }
  }
  
  private void e()
  {
    Object localObject = HardCodeUtil.a(2131715206);
    String str = SharedPreUtils.g(this.jdField_a_of_type_AndroidContentContext, "thxWord");
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.setText((CharSequence)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.length());
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject instanceof GameRoomChatPie)) {
      ((GameRoomChatPie)localObject).az();
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public abstract View a(BaseChatItemLayout paramBaseChatItemLayout);
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    TroopGiftMsgItemBuilder.TroopGiftMsgHolder localTroopGiftMsgHolder = (TroopGiftMsgItemBuilder.TroopGiftMsgHolder)paramViewHolder;
    if (paramView == null)
    {
      paramBaseChatItemLayout = a(paramBaseChatItemLayout);
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramBaseChatItemLayout);
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379229));
      localTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379228));
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379226));
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367701));
      localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363513));
      localTroopGiftMsgHolder.jdField_c_of_type_AndroidViewView = localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131369090);
      localTroopGiftMsgHolder.jdField_d_of_type_AndroidViewView = localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379227);
      localTroopGiftMsgHolder.jdField_c_of_type_AndroidWidgetButton = ((Button)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367692));
      localTroopGiftMsgHolder.jdField_d_of_type_AndroidWidgetButton = ((Button)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367691));
      localTroopGiftMsgHolder.e = ((Button)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367687));
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367693));
      localTroopGiftMsgHolder.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367688));
      localTroopGiftMsgHolder.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367690));
      localTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetButton = ((Button)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367689));
      int i = (int)(this.jdField_a_of_type_Float * 220.0F);
      int j = (int)(i - this.jdField_a_of_type_Float * 10.0F);
      paramViewHolder = (RelativeLayout.LayoutParams)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367693).getLayoutParams();
      paramViewHolder.width = j;
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367693).setLayoutParams(paramViewHolder);
      paramViewHolder = (LinearLayout.LayoutParams)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367692).getLayoutParams();
      int k = j / 2;
      paramViewHolder.width = ((int)(k - this.jdField_a_of_type_Float * 1.0F));
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367692).setLayoutParams(paramViewHolder);
      paramViewHolder = (LinearLayout.LayoutParams)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367691).getLayoutParams();
      paramViewHolder.width = k;
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367691).setLayoutParams(paramViewHolder);
      paramViewHolder = (RelativeLayout.LayoutParams)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367688).getLayoutParams();
      paramViewHolder.width = j;
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367688).setLayoutParams(paramViewHolder);
      paramViewHolder = (LinearLayout.LayoutParams)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367687).getLayoutParams();
      paramViewHolder.width = j;
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367687).setLayoutParams(paramViewHolder);
      paramViewHolder = (RelativeLayout.LayoutParams)localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363513).getLayoutParams();
      paramViewHolder.width = i;
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363513).setLayoutParams(paramViewHolder);
      localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(13.0F);
      localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
    }
    else
    {
      paramBaseChatItemLayout = paramView;
    }
    localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = a(paramChatMessage);
    MessageForTroopGift localMessageForTroopGift = a((MessageForTroopGift)paramChatMessage, localTroopGiftMsgHolder);
    b(localTroopGiftMsgHolder, localMessageForTroopGift);
    a(localTroopGiftMsgHolder);
    localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift = localMessageForTroopGift;
    if (!localMessageForTroopGift.isInteract())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append(localMessageForTroopGift.title);
      paramChatMessage.append(localMessageForTroopGift.subtitle);
      paramChatMessage = new ColorNickText(paramChatMessage.toString(), 16).a();
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramChatMessage);
      localTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    else
    {
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopGift.title);
      localTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageForTroopGift.subtitle);
      localTroopGiftMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7829368);
    }
    c(localTroopGiftMsgHolder, localMessageForTroopGift);
    localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetButton.setText(localMessageForTroopGift.comefrom);
    localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localMessageForTroopGift.comefrom);
    paramChatMessage = localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
    paramViewHolder = new StringBuilder();
    paramViewHolder.append(localMessageForTroopGift.giftPicId);
    paramViewHolder.append("");
    paramChatMessage.setTag(2131373865, paramViewHolder.toString());
    if (!localMessageForTroopGift.isInteract())
    {
      localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new ColorDrawable(localMessageForTroopGift.objColor));
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    else
    {
      localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130851119);
      localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    Object localObject = null;
    paramView = null;
    paramChatMessage = paramView;
    paramViewHolder = localObject;
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      paramChatMessage = paramView;
      paramViewHolder = localObject;
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130851118);
      paramChatMessage = paramView;
      paramViewHolder = localObject;
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130851118);
      paramChatMessage = paramView;
      paramViewHolder = localObject;
      paramView = URLDrawable.getDrawable(localMessageForTroopGift.makeGiftIconUrl(), localURLDrawableOptions);
      paramChatMessage = paramView;
      paramViewHolder = paramView;
      paramView.setDownloadListener(new TroopGiftMsgItemBuilder.5(this, paramView, localMessageForTroopGift, localTroopGiftMsgHolder));
    }
    catch (Exception paramViewHolder)
    {
      paramView = paramChatMessage;
      if (QLog.isColorLevel())
      {
        QLog.d("ChatItemBuilder", 2, paramViewHolder.getMessage());
        paramView = paramChatMessage;
      }
    }
    catch (OutOfMemoryError paramChatMessage)
    {
      paramView = paramViewHolder;
      if (QLog.isColorLevel())
      {
        QLog.d("ChatItemBuilder", 2, paramChatMessage.getMessage());
        paramView = paramViewHolder;
      }
    }
    a(localTroopGiftMsgHolder, localMessageForTroopGift, paramView);
    localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
    paramChatMessage = new TroopGiftMsgItemBuilder.ClickAction(this, localMessageForTroopGift, localTroopGiftMsgHolder);
    localTroopGiftMsgHolder.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.e.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(paramOnLongClickAndTouchListener);
    localTroopGiftMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(new TroopGiftMsgItemBuilder.6(this, paramOnLongClickAndTouchListener));
    localTroopGiftMsgHolder.jdField_c_of_type_AndroidViewView.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.jdField_c_of_type_AndroidViewView.setOnLongClickListener(paramOnLongClickAndTouchListener);
    localTroopGiftMsgHolder.jdField_c_of_type_AndroidViewView.setOnTouchListener(new TroopGiftMsgItemBuilder.7(this, paramOnLongClickAndTouchListener));
    paramChatMessage = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if ((localMessageForTroopGift.isLoading) && (paramChatMessage.b(TroopGiftUtil.b(localMessageForTroopGift))))
    {
      paramChatMessage.a(localTroopGiftMsgHolder);
      if (QLog.isColorLevel())
      {
        paramChatMessage = new StringBuilder();
        paramChatMessage.append("VISIBLE uniseq = ");
        paramChatMessage.append(localMessageForTroopGift.uniseq);
        QLog.d("ChatItemBuilder", 2, paramChatMessage.toString());
      }
      localTroopGiftMsgHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
    else
    {
      localTroopGiftMsgHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
      paramChatMessage.b(localTroopGiftMsgHolder);
    }
    a(localMessageForTroopGift);
    a(localTroopGiftMsgHolder, localMessageForTroopGift);
    return paramBaseChatItemLayout;
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return ((MessageForTroopGift)paramChatMessage).title;
  }
  
  public String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".gift/");
    localStringBuilder.append("troopGift_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".png");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(Bitmap paramBitmap, int paramInt, BubbleImageView paramBubbleImageView, String paramString)
  {
    if ((paramBitmap != null) && (paramBubbleImageView != null))
    {
      if (paramString == null) {
        return;
      }
      Object localObject1 = new File(a(paramString, paramInt));
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("troopGift_");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(".png");
      localObject2 = ((StringBuilder)localObject2).toString();
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(jdField_a_of_type_JavaLangString, 0);
      long l1 = localSharedPreferences.getLong((String)localObject2, 0L);
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      int i;
      if ((l1 != 0L) && (l2 - l1 < 259200000L)) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool;
      if (this.jdField_a_of_type_JavaUtilMap.get(localObject2) != null) {
        bool = ((Boolean)this.jdField_a_of_type_JavaUtilMap.get(localObject2)).booleanValue();
      } else {
        bool = false;
      }
      if ((((File)localObject1).exists()) && (i != 0))
      {
        a(paramBubbleImageView, paramInt, paramString);
        return;
      }
      if (bool)
      {
        localObject1 = (ArrayList)this.jdField_b_of_type_JavaUtilMap.get(localObject2);
        paramBitmap = (Bitmap)localObject1;
        if (localObject1 == null)
        {
          paramBitmap = new ArrayList();
          this.jdField_b_of_type_JavaUtilMap.put(localObject2, paramBitmap);
        }
        paramBitmap.add(new TroopGiftMsgItemBuilder.2(this, paramBubbleImageView, paramString, paramInt));
        return;
      }
      this.jdField_a_of_type_JavaUtilMap.put(localObject2, Boolean.valueOf(true));
      paramBubbleImageView.setImageDrawable(new ColorDrawable(paramInt));
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      ThreadManager.post(new TroopGiftMsgItemBuilder.3(this, paramString, paramInt, paramBitmap, paramBubbleImageView, (String)localObject2, localSharedPreferences, l2), 8, null, false);
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, BaseChatItemLayout.i);
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.isSend();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramView, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */