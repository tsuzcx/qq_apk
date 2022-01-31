package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.MagicTip;
import com.tencent.mobileqq.emoticon.VasEmojiManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.magicface.drawable.PngFrameDrawable;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.CommercialDrainageManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import vat;
import vau;
import vay;
import vaz;
import vba;
import vbb;
import vbc;
import vbd;
import vbe;
import vbf;
import vbg;
import vbh;
import vbi;
import vbj;
import vbk;
import vbl;
import vbn;
import vbo;
import vbp;
import vbr;
import vbs;

public class MarketFaceItemBuilder
  extends BaseBubbleBuilder
  implements MediaPlayerManager.Callback
{
  public static ChatMessage a;
  public static PicEmoticonInfo a;
  public static int b;
  public static long c;
  public MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars a;
  public EmojiManager a;
  EmoticonPackageDownloadListener a;
  public List a;
  public Context b;
  public int c;
  public boolean c;
  public int d;
  private long d;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public MarketFaceItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new vau(this);
    this.jdField_c_of_type_Int = 320;
    this.jdField_d_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager = ((EmojiManager)paramQQAppInterface.getManager(42));
    if ((this.jdField_b_of_type_AndroidContentContext instanceof SplashActivity)) {
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    boolean bool = true;
    FavroamingDBManager localFavroamingDBManager = (FavroamingDBManager)paramQQAppInterface.getManager(148);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getFavEmoticonList from addEmotionToFavorite.");
    }
    List localList = localFavroamingDBManager.a();
    int j;
    int i;
    if (localList != null)
    {
      j = 0;
      int m = 0;
      int n;
      for (i = 1; j < localList.size(); i = n)
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        int k;
        if (!TextUtils.isEmpty(localCustomEmotionData.RomaingType))
        {
          k = m;
          if ("needDel".equals(localCustomEmotionData.RomaingType)) {}
        }
        else
        {
          k = m + 1;
        }
        if ((localCustomEmotionData.isMarkFace) && (localCustomEmotionData.emoPath.equals(paramEmoticon.epId)) && (localCustomEmotionData.eId.equals(paramEmoticon.eId)))
        {
          if (localFavroamingDBManager.a(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new vbe(paramContext));
            }
            if (paramQQAppInterface != null) {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
            }
          }
          while (paramHandler == null) {
            return 0;
          }
          paramHandler.post(new vbf(paramContext));
          return 0;
        }
        n = i;
        if (i < localCustomEmotionData.emoId) {
          n = localCustomEmotionData.emoId;
        }
        j += 1;
        m = k;
      }
      if (m >= FavEmoConstant.a) {
        j = -2;
      }
    }
    for (;;)
    {
      paramHandler = new CustomEmotionData();
      paramHandler.uin = paramQQAppInterface.getCurrentAccountUin();
      paramHandler.emoId = (i + 1);
      paramHandler.isMarkFace = true;
      paramHandler.emoPath = paramEmoticon.epId;
      paramHandler.eId = paramEmoticon.eId;
      paramEmoticon = ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramEmoticon.epId);
      if (paramEmoticon != null) {
        if (paramEmoticon.isAPNG != 2) {
          break label403;
        }
      }
      for (;;)
      {
        paramHandler.isAPNG = bool;
        paramEmoticon = (FavroamingManager)paramQQAppInterface.getManager(102);
        if (paramEmoticon != null) {
          paramEmoticon.a(paramHandler, new EmoAddedAuthCallback(paramQQAppInterface, paramContext, paramHandler, null, 0));
        }
        if (jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
          a(paramQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect_suc", 0);
        }
        return j;
        label403:
        bool = false;
      }
      j = 0;
      continue;
      i = 1;
      j = 0;
    }
  }
  
  private int a(MarketFaceItemBuilder.Holder paramHolder, ChatMessage paramChatMessage)
  {
    if ((paramHolder == null) || (paramChatMessage == null))
    {
      j = -1;
      return j;
    }
    MarkFaceMessage localMarkFaceMessage = ((MessageForMarketFace)paramChatMessage).mMarkFaceMessage;
    boolean bool1 = localMarkFaceMessage.isReword;
    int i = localMarkFaceMessage.copywritingType;
    String str1 = localMarkFaceMessage.copywritingContent;
    String str2 = localMarkFaceMessage.jumpUrl;
    boolean bool2 = localMarkFaceMessage.shouldDisplay;
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "getBubbleView, marketMsg = " + localMarkFaceMessage);
    }
    int j = -1;
    MagicTip localMagicTip = (MagicTip)VasEmojiManager.a.get(String.valueOf(localMarkFaceMessage.dwTabID));
    if (localMagicTip != null)
    {
      i = j;
      if (localMagicTip.c.equals("redpacket"))
      {
        i = j;
        if (!paramChatMessage.isSend())
        {
          if (localMagicTip.b != null)
          {
            paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(CommercialDrainageManager.g));
            paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(2131362311, localMagicTip.a);
            paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(2131362312, localMagicTip.b);
            paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMagicTip.b);
            paramHolder.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
            paramHolder.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
          }
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new vbn(this, paramHolder, localMarkFaceMessage));
          i = 1;
        }
      }
    }
    for (;;)
    {
      paramChatMessage = paramHolder.jdField_a_of_type_AndroidWidgetTextView.getTag();
      int k = -1;
      if ((paramChatMessage instanceof Integer)) {
        k = ((Integer)paramChatMessage).intValue();
      }
      j = i;
      if (paramHolder.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break;
      }
      j = i;
      if (k == -1) {
        break;
      }
      paramChatMessage = (String)paramHolder.jdField_a_of_type_AndroidWidgetTextView.getTag(2131362311);
      paramChatMessage = a(k, paramHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), paramChatMessage);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramChatMessage);
      return i;
      if ((bool2) && (i != CommercialDrainageManager.a))
      {
        if (str1 != null)
        {
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(i));
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(2131362311, localMarkFaceMessage.from);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(2131362312, str1);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
        }
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new vbo(this, i, str1, str2, localMarkFaceMessage, paramHolder));
        if (localMarkFaceMessage.showIpProduct) {
          i = 4;
        } else {
          i = 2;
        }
      }
      else if ((bool1) && (i == CommercialDrainageManager.a))
      {
        paramChatMessage = a();
        if (paramChatMessage != null)
        {
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramChatMessage);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
        }
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new vbp(this, paramHolder));
        i = 3;
      }
      else
      {
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        i = j;
      }
    }
  }
  
  private SpannableString a()
  {
    SpannableString localSpannableString = new SpannableString("给原创表情赞赏");
    int i = "给原创表情赞赏".indexOf("赞赏");
    int j = "赞赏".length();
    localSpannableString.setSpan(new ForegroundColorSpan(-31676), i, j + i, 33);
    return localSpannableString;
  }
  
  private SpannableString a(int paramInt, String paramString1, String paramString2)
  {
    String str = "";
    Object localObject = paramString2;
    int i;
    if (TextUtils.isEmpty(paramString2))
    {
      i = 2131436481;
      switch (paramInt)
      {
      default: 
        paramString2 = str;
        paramInt = i;
      }
    }
    for (;;)
    {
      localObject = this.jdField_b_of_type_AndroidContentContext.getString(paramInt, new Object[] { paramString2 });
      paramString2 = (String)localObject + paramString1;
      localObject = new SpannableString(paramString2);
      paramInt = paramString2.indexOf(paramString1);
      i = paramString1.length();
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-31676), paramInt, i + paramInt, 33);
      return localObject;
      paramInt = 2131436482;
      paramString2 = "电影";
      continue;
      paramString2 = "游戏";
      paramInt = i;
      continue;
      paramString2 = "动漫";
      paramInt = i;
      continue;
      paramString2 = "小说";
      paramInt = i;
    }
  }
  
  private QQProgressDialog a()
  {
    if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a == null) {
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a = new QQProgressDialog(this.jdField_b_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a;
    }
    return null;
  }
  
  private String a()
  {
    try
    {
      i = NetworkUtil.a(this.jdField_b_of_type_AndroidContentContext);
      switch (i)
      {
      default: 
        return "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
      return "2G";
    }
    return "3G";
    return "4G";
    return "wifi";
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, EmojiManager.jdField_b_of_type_Int);
  }
  
  public static void a(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, int paramInt2, String paramString, SessionInfo paramSessionInfo)
  {
    if (paramEmoticon == null) {
      QLog.d("MarketFaceItemBuilder", 1, "can not find emoticon");
    }
    Handler localHandler;
    do
    {
      do
      {
        return;
        localHandler = new Handler(Looper.getMainLooper());
        if (paramInt2 != 0) {
          break label184;
        }
        if (7 != paramInt1 % 1000) {
          break;
        }
        try
        {
          paramQQAppInterface = new Bundle();
          paramQQAppInterface.putInt("forward_type", 9);
          paramEmoticon = new Intent();
          paramEmoticon.putExtras(paramQQAppInterface);
          ForwardBaseOption.a((BaseActivity)paramContext, paramEmoticon, 21);
          return;
        }
        catch (Exception paramContext) {}
      } while (!QLog.isColorLevel());
      QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, paramContext.getMessage());
      return;
      if (6 == paramInt1 % 1000)
      {
        ThreadManager.post(new vbb(paramContext, paramQQAppInterface, paramEmoticon, localHandler), 5, null, true);
        return;
      }
    } while (107 != paramInt1 % 1000);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
    PicEmoticonInfo.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
    return;
    label184:
    if (paramInt2 < 0)
    {
      localHandler.post(new vbc(paramContext, paramString));
      QLog.i("MarketFaceItemBuilder", 1, "opType: " + paramInt1 + ",result:" + paramInt2);
      return;
    }
    localHandler.post(new vbd(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, PicEmoticonInfo paramPicEmoticonInfo, SessionInfo paramSessionInfo, QQProgressDialog paramQQProgressDialog)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo.a, 0, null, paramSessionInfo);
      return;
    }
    if ((!NetworkUtil.g(paramContext)) || (paramInt > 1000))
    {
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo.a, -404, "网络异常，请稍后再试", paramSessionInfo);
      return;
    }
    ((EmoticonHandler)paramQQAppInterface.a(12)).a(paramInt, Integer.valueOf(paramPicEmoticonInfo.a.epId).intValue(), paramPicEmoticonInfo.a.eId);
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 0) || (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 2) || (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 4)))
    {
      String str = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).b(str, new vbh(this, str, paramHolder));
    }
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder, String paramString)
  {
    ThreadManager.post(new vbr(this, paramString, paramHolder), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private void a(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder)
  {
    a(paramChatMessage, paramHolder, "");
  }
  
  private void a(ChatMessage paramChatMessage, MarketFaceItemBuilder.Holder paramHolder, String paramString)
  {
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && (!c(paramChatMessage))) {}
    for (boolean bool = false;; bool = true)
    {
      Object localObject3 = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a("fromAIO", bool);
      Object localObject1 = "";
      Object localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (((URLDrawable)localObject3).getStatus() == 1)
        {
          if ((((URLDrawable)localObject3).getStateTag() instanceof Bundle)) {
            localObject1 = ((Bundle)((URLDrawable)localObject3).getStateTag()).getString("display_type");
          }
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = localObject1;
            if (((String)localObject1).equals("aio_preview"))
            {
              localObject2 = paramHolder.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
              if ((localObject2 != null) && (((EmoticonPackage)localObject2).status == 2))
              {
                URLDrawable.removeMemoryCacheByUrl(((URLDrawable)localObject3).getURL().toString());
                localObject2 = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a("fromAIO", bool);
                paramString = (String)localObject1;
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      for (;;)
      {
        int j;
        label201:
        int m;
        label219:
        int k;
        int n;
        if ((localObject1 != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null)) {
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.width == 0)
          {
            j = 200;
            if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.height != 0) {
              break label670;
            }
            m = 200;
            k = j;
            i = m;
            if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.extensionWidth != 0)
            {
              k = j;
              i = m;
              if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.extensionHeight != 0)
              {
                k = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.extensionWidth;
                i = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.extensionHeight;
              }
            }
            j = k;
            if (k != i) {
              j = i;
            }
            n = (j * this.jdField_d_of_type_Int + (this.jdField_c_of_type_Int >> 1)) / this.jdField_c_of_type_Int;
            i = (this.jdField_d_of_type_Int * i + (this.jdField_c_of_type_Int >> 1)) / this.jdField_c_of_type_Int;
            paramHolder.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(n, i));
            localObject2 = paramHolder.jdField_a_of_type_AndroidWidgetTextView.getTag();
            if (!(localObject2 instanceof Integer)) {
              break label1215;
            }
          }
        }
        label670:
        label1057:
        label1195:
        label1215:
        for (int i = ((Integer)localObject2).intValue();; i = -1)
        {
          if ((paramHolder.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (i != -1))
          {
            localObject3 = (String)paramHolder.jdField_a_of_type_AndroidWidgetTextView.getTag(2131362311);
            String str = (String)paramHolder.jdField_a_of_type_AndroidWidgetTextView.getTag(2131362312);
            Paint localPaint = new Paint(1);
            localPaint.setTextSize(AIOUtils.a(12.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
            localPaint.setTextAlign(Paint.Align.LEFT);
            int i1 = (int)localPaint.measureText("...");
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
            for (j = (int)localPaint.measureText("来" + (String)localObject3);; j = (int)localPaint.measureText("来自电影"))
            {
              m = str.length();
              k = (int)localPaint.measureText(str) + j;
              localObject2 = "";
              while ((k > n) && (m > 0))
              {
                m -= 1;
                localObject2 = str.substring(0, m);
                k = (int)localPaint.measureText((String)localObject2) + i1 + j;
              }
              if (!paramString.equals("")) {}
              for (i = 1;; i = 0)
              {
                localObject2 = localObject1;
                if (i == 0) {
                  break label1221;
                }
                URLDrawable.removeMemoryCacheByUrl(((URLDrawable)localObject3).getURL().toString());
                localObject2 = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a("fromAIO", bool, true, paramHolder);
                paramString = (String)localObject1;
                localObject1 = localObject2;
                break;
              }
              j = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.width;
              break label201;
              m = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.height;
              break label219;
            }
            if (!((String)localObject2).equals(""))
            {
              localObject2 = a(i, (String)localObject2 + "...", (String)localObject3);
              paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            }
          }
          paramHolder.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          localObject2 = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
          if (localObject1 != null) {}
          switch (((URLDrawable)localObject1).getStatus())
          {
          default: 
            paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            ((BaseChatItemLayout)localObject2).setProgressVisable(true);
            paramHolder.d.setVisibility(8);
            paramHolder.c.setVisibility(8);
            paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
            if ((paramChatMessage.isFlowMessage) && (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 0)) {
              if (!(this.jdField_b_of_type_AndroidContentContext instanceof MultiForwardActivity))
              {
                if (!paramChatMessage.isSend()) {
                  break label1057;
                }
                paramHolder.c.setImageResource(2130843958);
                paramHolder.c.setVisibility(0);
              }
            }
            break;
          }
          for (;;)
          {
            if (localObject1 != null) {
              a(paramHolder, (URLDrawable)localObject1, paramString);
            }
            d(paramHolder);
            return;
            if (!MagicfaceViewController.a()) {
              paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            }
            if ((EmoticonUtils.a()) && (2 == paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.e(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)) && (!EmoticonUtils.c())) {
              break;
            }
            float f = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
            if ((f >= 0.0F) && (1.0F != f)) {
              break;
            }
            paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((BaseChatItemLayout)localObject2).setProgressVisable(false);
            break;
            paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            ((BaseChatItemLayout)localObject2).setProgressVisable(false);
            if (!AppSetting.jdField_b_of_type_Boolean) {
              break;
            }
            paramHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("表情下载失败");
            break;
            paramHolder.d.setImageResource(2130843958);
            paramHolder.d.setVisibility(0);
            continue;
            if ((paramChatMessage.isDui) && (DuiButtonImageView.jdField_a_of_type_Boolean) && (!HotChatUtil.a(paramChatMessage)))
            {
              paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
              if ((paramChatMessage.isSend()) || (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()))
              {
                paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
                paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.e();
              }
              else
              {
                if (!paramChatMessage.hasPlayedDui) {
                  paramChatMessage.hasPlayedDui = DuiButtonImageView.a(paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView);
                }
                for (;;)
                {
                  if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
                    break label1195;
                  }
                  paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(this);
                  paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(0);
                  break;
                  paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.f();
                }
                paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setOnClickListener(null);
                paramHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView.setVisibility(8);
              }
            }
          }
        }
        label1221:
        paramString = (String)localObject2;
        localObject1 = localObject3;
      }
    }
  }
  
  private void a(PicEmoticonInfo paramPicEmoticonInfo, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      str2 = a();
      if (paramPicEmoticonInfo == null) {}
      for (paramPicEmoticonInfo = "";; paramPicEmoticonInfo = paramPicEmoticonInfo.a.epId)
      {
        VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramPicEmoticonInfo, paramString);
        return;
      }
    case 3: 
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramPicEmoticonInfo == null) {}
      for (paramPicEmoticonInfo = "";; paramPicEmoticonInfo = paramPicEmoticonInfo.a.epId)
      {
        ReportController.b(paramString, "CliOper", "", "", "ep_mall", "0X8007187", 0, 0, paramPicEmoticonInfo, "", "", "");
        return;
      }
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    String str2 = a();
    if (paramPicEmoticonInfo == null) {}
    for (paramPicEmoticonInfo = "";; paramPicEmoticonInfo = paramPicEmoticonInfo.a.epId)
    {
      VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "yinliu_xiaoweiba_view", "AIO", 1, 0, 1, str2, paramPicEmoticonInfo, paramString, "1", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
  
  private static void b(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, String paramString1, String paramString2)
  {
    try
    {
      DialogUtil.b(paramContext, 230, paramString1, paramString2, 2131433015, 2131433753, new vbg(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new vbi()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private void b(MarketFaceItemBuilder.Holder paramHolder)
  {
    EmoticonPackage localEmoticonPackage;
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, Boolean.valueOf(false)))
    {
      EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.name;
      localEmoticonPackage.epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramHolder.jdField_e_of_type_Int != -1) {
        break label222;
      }
    }
    label222:
    for (localEmoticonPackage.rscType = PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue);; localEmoticonPackage.rscType = paramHolder.jdField_e_of_type_Int)
    {
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
      paramHolder.jdField_a_of_type_Boolean = false;
      ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = true;
      this.jdField_a_of_type_JavaUtilList.add(paramHolder);
      paramHolder.f.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(localEmoticonPackage, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void c(MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((4 != paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) || (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, true, true)) {
        break;
      }
      if (!EmoticonUtils.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = " + paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
        }
        paramHolder.f.setVisibility(8);
        return;
      }
    } while (-1.0F != this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId));
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    EmoticonPackage localEmoticonPackage = new EmoticonPackage();
    localEmoticonPackage.name = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.name;
    localEmoticonPackage.epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
    localEmoticonPackage.jobType = 5;
    localEmoticonPackage.type = 1;
    localEmoticonPackage.isMagicFaceDownloading = true;
    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
    this.jdField_a_of_type_JavaUtilList.add(paramHolder);
    paramHolder.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
    paramHolder.f.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(localEmoticonPackage, false);
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon gone,start download epId = " + paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, localEmoticonPackage.epId, "", "", "");
    return;
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.b()))
    {
      paramHolder.f.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source intacat epId = " + paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId);
      }
    }
    for (;;)
    {
      paramHolder.f.setImageResource(2130837576);
      if ((((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isSend()) || (!((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay) || (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a()) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().k())) {
        break;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
      a(paramHolder, "1");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
      return;
      paramHolder.f.setVisibility(8);
    }
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    ChatMessage localChatMessage;
    do
    {
      return false;
      localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    } while ((localChatMessage != paramChatMessage) && ((!(localChatMessage instanceof MessageForMarketFace)) || (localChatMessage.frienduin == null) || (!localChatMessage.frienduin.equals(paramChatMessage.frienduin)) || (localChatMessage.uniseq != paramChatMessage.uniseq)));
    return true;
  }
  
  private void d(MarketFaceItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_a_of_type_Boolean = false;
    if ((2 != paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) || (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).mMarkFaceMessage == null) || (!MagicfaceViewController.a())) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.e(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId))
      {
        if (!EmoticonUtils.a())
        {
          paramHolder.f.setVisibility(8);
          return;
        }
        if ((!EmoticonUtils.c()) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, Boolean.valueOf(false))) && (-1.0F == this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)))
        {
          EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.name;
          ((EmoticonPackage)localObject).epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
          ((EmoticonPackage)localObject).jobType = 3;
          ((EmoticonPackage)localObject).rscType = PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue);
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
          this.jdField_a_of_type_JavaUtilList.add(paramHolder);
          paramHolder.jdField_a_of_type_Boolean = ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay;
          paramHolder.f.setVisibility(8);
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a((EmoticonPackage)localObject, false);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
        }
      }
      else
      {
        if (PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue) == 1) {
          paramHolder.f.setVisibility(8);
        }
        while (((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay)
        {
          ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          localObject = new Emoticon();
          ((Emoticon)localObject).eId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId;
          ((Emoticon)localObject).epId = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
          ((Emoticon)localObject).magicValue = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue;
          ((Emoticon)localObject).jobType = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType;
          if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() != null) && (MagicfaceViewController.a())) {
            ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a((Emoticon)localObject, 1, ((MessageForMarketFace)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).senderuin, false);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
          return;
          paramHolder.f.setImageResource(2130837576);
          paramHolder.f.setVisibility(0);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    long l = System.currentTimeMillis();
    paramBaseChatItemLayout = (MessageForMarketFace)paramChatMessage;
    MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)paramViewHolder;
    int i;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      Object localObject2 = new RelativeLayout(this.jdField_b_of_type_AndroidContentContext);
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131362300);
      paramView = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      paramView.setId(2131361943);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131361877);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131361877);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).setId(2131361948);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131361943);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((FrameLayout)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramOnLongClickAndTouchListener = new vbs(this, this.jdField_b_of_type_AndroidContentContext);
      ((FrameLayout)localObject1).addView(paramOnLongClickAndTouchListener, -2, -2);
      localObject4 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      Object localObject5 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject5).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject5).setId(2131361942);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(1, 2131361948);
      ((RelativeLayout.LayoutParams)localObject6).addRule(8, 2131361948);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((ImageView)localObject5).setOnClickListener(this);
      localObject6 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject6).setId(2131361944);
      Object localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(1, 2131361948);
      ((RelativeLayout.LayoutParams)localObject7).addRule(15, 2131361948);
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject6, (ViewGroup.LayoutParams)localObject7);
      ((ImageView)localObject6).setOnClickListener(this);
      localObject7 = new DuiButtonImageView(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ((DuiButtonImageView)localObject7).setId(2131361945);
      Object localObject8 = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.a(50.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject8).addRule(1, 2131361948);
      ((RelativeLayout.LayoutParams)localObject8).addRule(8, 2131361948);
      ((RelativeLayout.LayoutParams)localObject8).setMargins(0, 0, 0, -AIOUtils.a(6.5F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject7, (ViewGroup.LayoutParams)localObject8);
      localObject8 = new ImageView(this.jdField_b_of_type_AndroidContentContext);
      ((ImageView)localObject8).setId(2131361946);
      Object localObject9 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject9).addRule(1, 2131361948);
      ((RelativeLayout.LayoutParams)localObject9).addRule(8, 2131361948);
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = AIOUtils.a(10.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject8, (ViewGroup.LayoutParams)localObject9);
      localObject9 = new TextView(this.jdField_b_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject9).setTextSize(12.0F);
      ((TextView)localObject9).setTextColor(-1);
      localLayoutParams.topMargin = AIOUtils.a(8.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      ((TextView)localObject9).setGravity(17);
      localLayoutParams.addRule(3, 2131362300);
      ((TextView)localObject9).setBackgroundDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130842181));
      ((TextView)localObject9).setPadding(AIOUtils.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.a(9.0F, this.jdField_b_of_type_AndroidContentContext.getResources()), AIOUtils.a(4.0F, this.jdField_b_of_type_AndroidContentContext.getResources()));
      paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      paramViewHolder.addView((View)localObject9, localLayoutParams);
      ((ImageView)localObject8).setOnClickListener(this);
      localObject2 = new ProgressBar(this.jdField_b_of_type_AndroidContentContext, null, 0);
      ((ProgressBar)localObject2).setId(2131361875);
      ((ProgressBar)localObject2).setIndeterminateDrawable(this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130838596));
      i = AIOUtils.a(16.0F, this.jdField_b_of_type_AndroidContentContext.getResources());
      localObject3 = new FrameLayout.LayoutParams(i, i);
      ((FrameLayout.LayoutParams)localObject3).gravity = 17;
      ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localHolder.jdField_e_of_type_AndroidWidgetImageView = paramOnLongClickAndTouchListener;
      localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
      localHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
      localHolder.c = paramView;
      localHolder.d = ((ImageView)localObject6);
      localHolder.jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView = ((DuiButtonImageView)localObject7);
      localHolder.f = ((ImageView)localObject8);
      localHolder.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
      localHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject9);
    }
    for (;;)
    {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((AppSetting.jdField_b_of_type_Boolean) && (a(paramChatMessage, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) && (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)) {
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setContentDescription("表情发送失败");
      }
      i = a(localHolder, paramChatMessage);
      new QueryTask(new vbk(this, localHolder), new vbl(this, localHolder, i, paramBaseChatItemLayout, paramChatMessage, l)).a(paramBaseChatItemLayout.mMarkFaceMessage);
      return paramViewHolder;
      if ((localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && (localHolder.jdField_b_of_type_AndroidWidgetImageView != null) && ((localHolder.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof AnimationDrawable))) {
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843978);
      }
      paramViewHolder = paramView;
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        localHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        paramViewHolder = paramView;
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new MarketFaceItemBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (!MsgUtils.a(paramChatMessage.issend)) {
        break label103;
      }
      localStringBuilder.append("发出表情");
    }
    for (;;)
    {
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramChatMessage.mMarkFaceMessage);
        if (paramChatMessage != null)
        {
          paramChatMessage = paramChatMessage.a;
          if ((paramChatMessage != null) && (paramChatMessage.name != null)) {
            localStringBuilder.append(paramChatMessage.name);
          }
        }
      }
      return localStringBuilder.toString();
      label103:
      localStringBuilder.append("发来表情");
    }
  }
  
  public void a()
  {
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$EmoticonDetailJsonDownloaderVars);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null))
    {
      QLog.e("MarketFaceItemBuilder", 1, "onMenuItemClicked emoticon is null");
      return;
    }
    if ((paramInt == 2131375567) || (paramInt == 2131361852) || (paramInt == 2131361853) || (paramInt == 2131361854))
    {
      ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, new vbj(this, paramInt, paramChatMessage));
      return;
    }
    if (paramInt == 2131375577)
    {
      super.c(paramChatMessage);
      return;
    }
    if (paramInt == 2131361906)
    {
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    String str1;
    String str2;
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSendFromLocal())
    {
      str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131433635);
      str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131433636);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 41) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null)) {
        a((MessageForMarketFace)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo);
      }
    }
    do
    {
      return;
      DialogUtil.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new vay(this, paramView), new vaz(this)).show();
      return;
      paramView = paramView.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
    } while (!(paramView instanceof URLDrawable));
    ((URLDrawable)paramView).restartDownload();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, ScreenUtil.a(10.0F), 0);
  }
  
  public void a(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable)
  {
    a(paramHolder, paramURLDrawable, "");
  }
  
  void a(MarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable, String paramString)
  {
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.f.setVisibility(8);
    paramHolder.jdField_b_of_type_Boolean = false;
    int i = paramURLDrawable.getStatus();
    if (paramURLDrawable.getHeader("2g_use_gif") != null) {
      i = 1;
    }
    for (;;)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
          str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
        }
      }
      if ("aio_preview".equals(str)) {
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a())
        {
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843978);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      while (!"big_sound".equals(str))
      {
        do
        {
          return;
        } while ((i != 1) || (paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.f != 3));
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837573);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramHolder.jdField_b_of_type_Boolean = true;
        return;
      }
      if (c(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
      {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2131034356);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843978);
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramMessageForMarketFace == null) || (paramPicEmoticonInfo == null) || (paramPicEmoticonInfo.a == null) || (paramPicEmoticonInfo.a.epId == null)) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_b_of_type_AndroidContentContext, null);
    localActionSheet.a(this.jdField_b_of_type_AndroidContentContext.getString(2131436086));
    localActionSheet.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131436087), 1);
    localActionSheet.a(this.jdField_b_of_type_AndroidContentContext.getResources().getString(2131436088), 1);
    localActionSheet.c(2131433015);
    localActionSheet.a(new vba(this, paramPicEmoticonInfo, localActionSheet, paramMessageForMarketFace));
    localActionSheet.show();
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    if (paramView != null)
    {
      paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843978);
      paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a("fromAIO", false);
      paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
    }
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer)
  {
    paramXListView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    if ((paramXListView == null) || (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null)) {
      return false;
    }
    if ((paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && (paramAudioPlayer.a(EmoticonUtils.o.replace("[epId]", paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId).replace("[eId]", paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId))))
    {
      paramView = paramXListView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a("fromAIO", true);
      paramXListView.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      PicEmoticonInfo.a(paramView);
      paramView = (AnimationDrawable)this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2131034356);
      paramXListView.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      paramView.start();
      return true;
    }
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if ((jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace))
    {
      MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localMessageForMarketFace.mMarkFaceMessage == null) || (localMessageForMarketFace.mMarkFaceMessage.stickerInfo == null)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 1)
        {
          jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
          if (AIOUtils.a(1) == 1) {
            localQQCustomMenu.a(2131361852, this.jdField_b_of_type_AndroidContentContext.getString(2131435873), 2130838311);
          }
          localQQCustomMenu.a(2131361853, this.jdField_b_of_type_AndroidContentContext.getString(2131435083), 2130838313);
          a(jdField_a_of_type_ComTencentMobileqqDataChatMessage, localQQCustomMenu);
          if ((paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 2) && (paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 4)) {
            localQQCustomMenu.a(2131361854, this.jdField_b_of_type_AndroidContentContext.getString(2131435872), 2130838293);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Ap_show_forward", 0);
        }
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
          a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        super.b(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext);
      }
      for (;;)
      {
        return localQQCustomMenu.a();
        jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.m = true;
    if (super.a()) {
      return;
    }
    Object localObject2;
    Drawable localDrawable;
    URLDrawable localURLDrawable;
    if (paramView.getId() == 2131361948)
    {
      localObject2 = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
      localDrawable = ((MarketFaceItemBuilder.Holder)localObject2).jdField_e_of_type_AndroidWidgetImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable))
      {
        localURLDrawable = (URLDrawable)localDrawable;
        paramView = localURLDrawable.getURL().getHost();
        if (!(localURLDrawable.getTag() instanceof Bundle)) {
          break label1578;
        }
        paramView = ((Bundle)localURLDrawable.getTag()).getString("display_type");
      }
    }
    label1161:
    label1578:
    for (;;)
    {
      switch (((URLDrawable)localDrawable).getStatus())
      {
      }
      Object localObject1;
      for (;;)
      {
        if ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType == 2) && (MagicfaceViewController.a())) {
          b((MarketFaceItemBuilder.Holder)localObject2);
        }
        if ((((URLDrawable)localDrawable).getStatus() != 1) && ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null) || (!((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.c()))) {
          break;
        }
        a((MarketFaceItemBuilder.Holder)localObject2);
        return;
        localObject1 = "";
        if ((localURLDrawable.getStateTag() instanceof Bundle)) {
          localObject1 = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
        }
        localURLDrawable.restartDownload();
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "msgOnclickListener| URLDrawable restartDownload status=" + localURLDrawable.getStatus());
        }
        a((MarketFaceItemBuilder.Holder)localObject2, localURLDrawable, (String)localObject1);
        ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        if ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) && ("big_sound".equals(paramView)))
        {
          jdField_c_of_type_Long = ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
          continue;
          if ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 0) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 2) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType != 4))
          {
            ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            if ("big_sound".equals(paramView))
            {
              if ((((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.isSound)) {
                if (c(((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
                } else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
                  QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433788, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
                } else {
                  MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
                }
              }
            }
            else if ("aio_preview".equals(paramView))
            {
              paramView = ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a("fromAIO", true);
              if (paramView != null)
              {
                ((MarketFaceItemBuilder.Holder)localObject2).jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
                ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                a((MarketFaceItemBuilder.Holder)localObject2, paramView);
                if (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()) {
                  jdField_c_of_type_Long = ((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
                }
              }
            }
          }
        }
      }
      if ((!(localDrawable instanceof PngFrameDrawable)) || (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null) || (!((MarketFaceItemBuilder.Holder)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.c())) {
        break;
      }
      a((MarketFaceItemBuilder.Holder)localObject2);
      return;
      if (paramView.getId() == 2131361942)
      {
        localObject1 = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
        if ((((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a()))
        {
          if (!c(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
            break label696;
          }
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        }
      }
      label696:
      do
      {
        do
        {
          for (;;)
          {
            super.onClick(paramView);
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
            {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433788, 0).b(this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
            }
            else
            {
              MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
              continue;
              if ((paramView.getId() == 2131361944) || (paramView.getId() == 2131361943))
              {
                localObject1 = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
                localObject2 = a();
                if (localObject2 != null)
                {
                  ((QQProgressDialog)localObject2).a(this.jdField_b_of_type_AndroidContentContext.getString(2131436091));
                  ((QQProgressDialog)localObject2).show();
                }
                ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, new vat(this, (MarketFaceItemBuilder.Holder)localObject1, (QQProgressDialog)localObject2));
              }
              else
              {
                if (paramView.getId() != 2131361945) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("MarketFaceItemBuilder", 2, "[Doutu] Dui Button Clicked.");
                }
                localObject1 = ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment();
                if (localObject1 != null)
                {
                  localObject1 = ((ChatFragment)localObject1).a();
                  if (localObject1 != null) {
                    ((BaseChatPie)localObject1).a().obtainMessage(79, null).sendToTarget();
                  } else if (QLog.isColorLevel()) {
                    QLog.d("MarketFaceItemBuilder", 2, "[Doutu] curPie is null.");
                  }
                }
                else if (QLog.isColorLevel())
                {
                  QLog.d("MarketFaceItemBuilder", 2, "[Doutu] chatFragment is null.");
                }
              }
            }
          }
        } while (paramView.getId() != 2131361946);
        localObject1 = (MarketFaceItemBuilder.Holder)AIOUtils.a(paramView);
        if ((((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a != null) && (2 == ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, Boolean.valueOf(false))) {
            break;
          }
          EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
          localObject2 = new EmoticonPackage();
          ((EmoticonPackage)localObject2).name = ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.name;
          ((EmoticonPackage)localObject2).epId = ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
          ((EmoticonPackage)localObject2).jobType = 3;
          ((EmoticonPackage)localObject2).type = 1;
          ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
          ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_Boolean = false;
          ((MessageForMarketFace)((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
          ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
          this.jdField_a_of_type_JavaUtilList.add(localObject1);
          ((MarketFaceItemBuilder.Holder)localObject1).f.setVisibility(8);
          ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a((EmoticonPackage)localObject2, false);
          ReportController.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
        }
      } while ((((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a == null) || (4 != ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.jobType) || (System.currentTimeMillis() - this.jdField_d_of_type_Long <= 3000L) || (!this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a()));
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, true, true)) {
        a((MarketFaceItemBuilder.Holder)localObject1, "0");
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, "", "", "");
        break;
        if ((((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null) || (!MagicfaceViewController.a()) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment() == null) || (((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a() == null)) {
          break label1161;
        }
        ((FragmentActivity)this.jdField_b_of_type_AndroidContentContext).getChatFragment().a().a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a, 1, ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, true);
        break label1161;
        EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
        localObject2 = new EmoticonPackage();
        ((EmoticonPackage)localObject2).name = ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.name;
        ((EmoticonPackage)localObject2).epId = ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
        ((EmoticonPackage)localObject2).jobType = 5;
        ((EmoticonPackage)localObject2).type = 1;
        ((EmoticonPackage)localObject2).isMagicFaceDownloading = true;
        ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_Boolean = false;
        ((MessageForMarketFace)((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).needToPlay = false;
        ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
        ((MarketFaceItemBuilder.Holder)localObject1).f.setVisibility(8);
        ((MarketFaceItemBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a((EmoticonPackage)localObject2, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder
 * JD-Core Version:    0.7.0.1
 */