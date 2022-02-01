package com.tencent.mobileqq.activity.aio.helper;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.text.SimpleDateFormat;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class AIOMultiActionHelper
  implements View.OnClickListener, ILifeCycleHelper
{
  protected LinearLayout a;
  protected ImageView b;
  protected ImageView c;
  protected ImageView d;
  protected ImageView e;
  protected ImageView f;
  protected View g;
  private final BaseChatPie h;
  private final QQAppInterface i;
  private final BaseActivity j;
  private final MqqHandler k;
  private final SessionInfo l;
  
  public AIOMultiActionHelper(BaseChatPie paramBaseChatPie)
  {
    this.h = paramBaseChatPie;
    this.i = paramBaseChatPie.d;
    this.j = paramBaseChatPie.aX();
    this.k = paramBaseChatPie.j();
    this.l = paramBaseChatPie.aE();
  }
  
  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = new ImageView(this.j);
    this.b.setId(2131430632);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    if (paramInt2 == 1) {
      ((LinearLayout.LayoutParams)localObject).setMargins(paramInt3, 0, 0, 0);
    } else {
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
    }
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setOnClickListener(this);
    if (AppSetting.e) {
      this.b.setContentDescription(HardCodeUtil.a(2131899201));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.j.getResources().getDrawable(2130839519);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.j.getResources().getDrawable(2130839520);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    this.b.setImageDrawable((Drawable)localObject);
    this.a.addView(this.b);
    if (paramBoolean1) {
      b(paramInt1, paramInt3);
    }
    if (paramBoolean3) {
      a(paramInt1, paramInt3);
    }
    ((MultiFavoriteHelper)this.h.q(11)).a(this.h, this.a, paramBoolean4, paramInt1, paramInt1, paramInt3, paramInt4);
    if (paramBoolean5) {
      e(paramInt1, paramInt3);
    }
    if (paramBoolean6) {
      d(paramInt1, paramInt3);
    }
    if (paramBoolean2) {
      c(paramInt1, paramInt3);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.e = new ImageView(this.j);
    this.e.setId(2131430638);
    if (AppSetting.e) {
      this.e.setContentDescription(HardCodeUtil.a(2131899223));
    }
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.e.setOnClickListener(this);
    localObject = new StateListDrawable();
    Drawable localDrawable = this.j.getResources().getDrawable(2130839479);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.j.getResources().getDrawable(2130839479);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.e.setImageDrawable((Drawable)localObject);
    this.a.addView(this.e);
  }
  
  private void d()
  {
    ReportController.b(this.i, "CliOper", "", "", "0X80067F6", "0X80067F6", 0, 0, "", "", "", "");
    if (!NetworkUtil.isNetSupport(this.j))
    {
      QQToast.makeText(this.i.getApp(), 2131889169, 0).show(this.h.A());
      return;
    }
    Object localObject3 = MultiMsgManager.a().i();
    if (((List)localObject3).size() == 0)
    {
      QQToast.makeText(this.i.getApp(), 2131896469, 0).show(this.h.A());
      return;
    }
    int m = 0;
    Object localObject2;
    while (m < ((List)localObject3).size())
    {
      localObject2 = (ChatMessage)((List)localObject3).get(m);
      localObject1 = localObject2;
      if ((localObject2 instanceof MessageForMarketFace)) {
        break label165;
      }
      if ((localObject2 instanceof MessageForPic))
      {
        localObject1 = localObject2;
        break label165;
      }
      m += 1;
    }
    Object localObject1 = null;
    label165:
    if (localObject1 == null)
    {
      QLog.e("Q.aio.BaseChatPie.AIOMultiActionHelper", 1, "add to custom face, no market face message or pic message selected");
      QQToast.makeText(this.i.getApp(), 2131896469, 0).show(this.h.A());
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("add to custom face, selected message=");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("Q.aio.BaseChatPie.AIOMultiActionHelper", 1, ((StringBuilder)localObject2).toString());
    }
    if ((localObject1 instanceof MessageForPic))
    {
      localObject1 = (MessageForPic)localObject1;
      localObject2 = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL((PicUiInterface)localObject1, 1), -1, -1, null, null, false);
      ((URLDrawable)localObject2).setTag(localObject1);
      AIOGalleryUtils.a(this.j, this.i, (URLDrawable)localObject2, ((MessageForPic)localObject1).frienduin, this.j.getResources().getDimensionPixelSize(2131299920), null, null);
      ReportController.b(this.i, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
    }
    else if ((localObject1 instanceof MessageForMarketFace))
    {
      ReportController.b(this.i, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", "", "", "");
      localObject3 = (MessageForMarketFace)localObject1;
      localObject2 = this.h.af;
      if (this.h.af != null)
      {
        this.h.af.a(this.j.getString(2131888894));
        this.h.af.show();
      }
      localObject1 = (IPicEmoticonInfo)((IEmoticonManagerService)this.i.getRuntimeService(IEmoticonManagerService.class)).syncGetEmoticonInfo(((MessageForMarketFace)localObject3).mMarkFaceMessage);
      EmoticonPackage localEmoticonPackage = ((IEmoticonManagerService)this.i.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(((IPicEmoticonInfo)localObject1).getEmoticon().epId);
      MarketFaceItemBuilder.x = (ChatMessage)localObject3;
      MarketFaceItemBuilder.w = (IPicEmoticonInfo)localObject1;
      if ((localEmoticonPackage != null) && (localEmoticonPackage.name != null) && ((localEmoticonPackage.mobileFeetype != 0) || (localEmoticonPackage.downloadCount != 0)))
      {
        m = this.i.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
        int n = (int)(System.currentTimeMillis() / 1000L);
        if ((n - m <= 86400) && (n >= m))
        {
          MarketFaceItemBuilder.a(6, this.j, this.i, localEmoticonPackage, (IPicEmoticonInfo)localObject1, this.l, (QQProgressDialog)localObject2);
        }
        else
        {
          localObject3 = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
          ((MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars)localObject3).a(6, this.i, this.j, (IPicEmoticonInfo)localObject1, this.l, (QQProgressDialog)localObject2);
          localObject2 = (IEmojiManagerService)this.i.getRuntimeService(IEmojiManagerService.class, "");
          ((IEmojiManagerService)localObject2).getEmojiListenerManager().addEmotionJsonDownloadListener((EmotionJsonDownloadListener)localObject3);
          ((IEmojiManagerService)localObject2).startDownloadEmosmJson(((IPicEmoticonInfo)localObject1).getEmoticon().epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
        }
      }
      else
      {
        localObject3 = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
        ((MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars)localObject3).a(6, this.i, this.j, (IPicEmoticonInfo)localObject1, this.l, (QQProgressDialog)localObject2);
        localObject2 = (IEmojiManagerService)this.i.getRuntimeService(IEmojiManagerService.class);
        ((IEmojiManagerService)localObject2).getEmojiListenerManager().addEmotionJsonDownloadListener((EmotionJsonDownloadListener)localObject3);
        ((IEmojiManagerService)localObject2).startDownloadEmosmJson(((IPicEmoticonInfo)localObject1).getEmoticon().epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
      }
    }
    this.h.a(false, null, false);
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    this.f = new ImageView(this.j);
    this.f.setId(2131430633);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.f.setOnClickListener(this);
    this.f.setContentDescription(HardCodeUtil.a(2131917449));
    this.f.setImageDrawable(this.j.getResources().getDrawable(2130839536));
    this.a.addView(this.f);
    localObject = this.l;
    if (localObject != null)
    {
      TroopEssenceReportUtil.i(this.i, ((SessionInfo)localObject).b);
      TroopEssenceReportUtil.j(this.i, this.l.b);
    }
  }
  
  private void e()
  {
    int m = MultiMsgManager.a().f();
    ReportController.b(this.i, "CliOper", "", "", "0X80059B6", "0X80059B6", 0, 0, "", "", "", "");
    ReportController.b(this.i, "CliOper", "", "", AIOShareActionSheet.f, AIOShareActionSheet.f, 0, m, "", "", "", "");
    if ((ChatActivityFacade.e != null) && (ChatActivityFacade.e.isShowing())) {
      return;
    }
    Object localObject1 = MultiMsgManager.a().i();
    if (((List)localObject1).size() == 0)
    {
      QQToast.makeText(this.i.getApp(), 2131896469, 0).show(this.h.A());
      ReportController.b(this.i, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "0", "", "", "");
      if (this.l.a == 1008)
      {
        localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        ReportController.b(this.i, "dc00899", "Pb_account_lifeservice", this.l.b, "0X80064F9", "0X80064F9", 0, 0, (String)localObject1, "1", "", "");
      }
      return;
    }
    MultiMsgManager.a().b((List)localObject1);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checklist.size = ");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.d("MultiMsg_TAG", 4, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(((List)localObject1).size());
    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, localStringBuilder.toString(), "", "", "");
    if (this.l.a == 1008)
    {
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      ReportController.b(this.i, "dc00899", "Pb_account_lifeservice", this.l.b, "0X80064F9", "0X80064F9", 0, 0, (String)localObject2, "0", "", "");
    }
    ChatActivityFacade.a(this.j, this.i, (List)localObject1);
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    ImageView localImageView = new ImageView(this.j);
    localImageView.setId(2131430637);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localImageView.setOnClickListener(this);
    if (AppSetting.e) {
      localImageView.setContentDescription(HardCodeUtil.a(2131899202));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.j.getResources().getDrawable(2130839604);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.j.getResources().getDrawable(2130839604);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localImageView.setImageDrawable((Drawable)localObject);
    this.a.addView(localImageView);
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(0);
    }
    localObject = (AIOLongShotHelper)this.h.q(15);
    SelectToBottomHelper localSelectToBottomHelper = (SelectToBottomHelper)this.h.q(40);
    if (!((AIOLongShotHelper)localObject).c()) {
      localSelectToBottomHelper.b();
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      this.g.setClickable(true);
    }
    localObject = (AIOShortcutBarHelper)this.h.q(52);
    if (localObject != null)
    {
      ((AIOShortcutBarHelper)localObject).d(16);
      ((AIOShortcutBarHelper)localObject).d(11);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = new ImageView(this.j);
    this.d.setId(2131430635);
    if (AppSetting.e) {
      this.d.setContentDescription(HardCodeUtil.a(2131899210));
    }
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.d.setOnClickListener(this);
    localObject = new StateListDrawable();
    Drawable localDrawable = this.j.getResources().getDrawable(2130839548);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.j.getResources().getDrawable(2130839549);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localDrawable = this.j.getResources().getDrawable(2130839548);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.d.setImageDrawable((Drawable)localObject);
    this.a.addView(this.d);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.c;
    if (localImageView != null) {
      localImageView.setEnabled(paramBoolean);
    }
  }
  
  public void b()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    ((SelectToBottomHelper)this.h.q(40)).a();
    localObject = this.g;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (AIOShortcutBarHelper)this.h.q(52);
    if (localObject != null)
    {
      ((AIOShortcutBarHelper)localObject).d(15);
      ((AIOShortcutBarHelper)localObject).d(12);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.c = new ImageView(this.j);
    this.c.setId(2131430630);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.setOnClickListener(this);
    if (AppSetting.e) {
      this.c.setContentDescription(HardCodeUtil.a(2131899192));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.j.getResources().getDrawable(2130839537);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.j.getResources().getDrawable(2130839538);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localDrawable = this.j.getResources().getDrawable(2130839537);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.c.setImageDrawable((Drawable)localObject);
    this.a.addView(this.c);
  }
  
  public void c()
  {
    List localList = MultiMsgManager.a().i();
    Object localObject = this.h;
    if ((localObject != null) && (((BaseChatPie)localObject).ah != null) && (this.h.ah.a == 1))
    {
      localObject = this.f;
      if (localObject != null)
      {
        if (((ImageView)localObject).getVisibility() != 0) {
          return;
        }
        long l1 = 0L;
        try
        {
          long l2 = Long.valueOf(this.h.ah.b).longValue();
          l1 = l2;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (!TroopEssenceUtil.a(this.i, l1, localList))
        {
          this.f.setImageDrawable(this.j.getResources().getDrawable(2130839535));
          this.f.setEnabled(false);
          return;
        }
        this.f.setImageDrawable(this.j.getResources().getDrawable(2130839536));
        this.f.setEnabled(true);
      }
    }
  }
  
  public String getTag()
  {
    return "Q.aio.BaseChatPie.AIOMultiActionHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[0];
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    switch (paramView.getId())
    {
    case 2131430631: 
    case 2131430634: 
    case 2131430636: 
    default: 
      break;
    case 2131430638: 
      ((MultiForwardHelper)this.h.q(1)).a();
      break;
    case 2131430637: 
      localObject1 = AIOLongShotHelper.f();
      if (localObject1 != null) {
        ((AIOLongShotHelper)localObject1).a(paramView);
      }
      break;
    case 2131430635: 
      int m = MultiMsgManager.a().f();
      ReportController.b(this.i, "CliOper", "", "", AIOShareActionSheet.g, AIOShareActionSheet.g, 0, m, "", "", "", "");
      ((MultiForwardHelper)this.h.q(1)).a(this.h.V, false);
      break;
    case 2131430633: 
      localObject1 = (TroopEssenceMsgManager)this.i.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
      if (localObject1 != null)
      {
        Object localObject2 = this.l;
        if ((localObject2 != null) && (((SessionInfo)localObject2).a == 1))
        {
          localObject2 = this.f;
          if ((localObject2 != null) && (((ImageView)localObject2).isEnabled()))
          {
            ((TroopEssenceMsgManager)localObject1).a(this.l.b, this.i.getCurrentUin());
            this.h.a(false, null, false);
          }
        }
      }
      break;
    case 2131430632: 
      e();
      break;
    case 2131430630: 
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOMultiActionHelper
 * JD-Core Version:    0.7.0.1
 */