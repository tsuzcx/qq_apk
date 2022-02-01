package com.etrump.mixlayout;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.richstatus.ActionInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.TipsInfo;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableDownloadHelper;
import com.tencent.mobileqq.vas.qqvaluecard.QqValueGetValueHandler;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VasFontIPCModule
  extends QIPCModule
{
  public static String a = "action_download_hy_so";
  public static String b = "action_download_fz_so";
  public static String c = "action_download_font";
  public static String d = "action_download_signature_config";
  public static String e = "action_get_my_signature";
  public static String f = "action_change_status";
  public static String g = "action_get_action";
  public static String h = "action_download_use_quickupdate";
  public static String i = "action_get_shield_font";
  public static String j = "action_get_history_signature_num";
  public static String k = "action_download_gldrawable";
  public static String l = "action_update_qqvalue";
  private static VasFontIPCModule m;
  private Vector<Integer> n = new Vector();
  private Vector<Integer> o = new Vector();
  private AtomicBoolean p = new AtomicBoolean(false);
  private AtomicBoolean q = new AtomicBoolean(false);
  private AtomicInteger r = new AtomicInteger(0);
  private AtomicInteger s = new AtomicInteger(0);
  private AtomicInteger t = new AtomicInteger(0);
  private ConcurrentHashMap<Integer, Integer> u = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> v = new ConcurrentHashMap();
  private CallBacker w = new VasFontIPCModule.2(this);
  
  private VasFontIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static VasFontIPCModule a()
  {
    try
    {
      if (m == null) {
        m = new VasFontIPCModule("VasFontIPCModule");
      }
      VasFontIPCModule localVasFontIPCModule = m;
      return localVasFontIPCModule;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Integer localInteger;
    Object localObject;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 4) {
        return;
      }
      this.q.set(false);
      localVector = new Vector(this.o);
      localIterator = localVector.iterator();
      while (localIterator.hasNext())
      {
        localInteger = (Integer)localIterator.next();
        localObject = new Bundle();
        ((Bundle)localObject).putInt("font_type", paramInt1);
        localObject = EIPCResult.createResult(paramInt2, (Bundle)localObject);
        callbackResult(localInteger.intValue(), (EIPCResult)localObject);
      }
      this.o.removeAll(localVector);
      return;
    }
    this.p.set(false);
    Vector localVector = new Vector(this.n);
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      localInteger = (Integer)localIterator.next();
      localObject = new Bundle();
      ((Bundle)localObject).putInt("font_type", paramInt1);
      localObject = EIPCResult.createResult(paramInt2, (Bundle)localObject);
      callbackResult(localInteger.intValue(), (EIPCResult)localObject);
    }
    this.n.removeAll(localVector);
  }
  
  public void a(int paramInt1, RichStatus paramRichStatus, TipsInfo paramTipsInfo, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramRichStatus = new StringBuilder();
      paramRichStatus.append("onChangeStatus result = ");
      paramRichStatus.append(paramInt1);
      QLog.d("Signature", 2, paramRichStatus.toString());
    }
    if (this.r.get() > 0)
    {
      paramRichStatus = new Bundle();
      paramRichStatus.putInt("notify_type", 5);
      paramRichStatus.putInt("result", paramInt1);
      paramRichStatus.putInt("type", paramInt2);
      if ((paramTipsInfo != null) && (paramTipsInfo.errorDesc != null)) {
        paramRichStatus.putString("errorDesc", paramTipsInfo.errorDesc);
      }
      if ((paramInt2 == 0) && (paramTipsInfo != null))
      {
        paramRichStatus.putBoolean("hasTipsInfo", false);
        if (paramTipsInfo.type > 0)
        {
          paramRichStatus.putInt("result", paramTipsInfo.ret);
          paramRichStatus.putBoolean("hasTipsInfo", true);
          paramRichStatus.putInt("tips_type", paramTipsInfo.type);
          paramRichStatus.putString("tips_titleWording", paramTipsInfo.titleWording);
          paramRichStatus.putString("tips_wording", paramTipsInfo.wording);
          paramRichStatus.putString("tips_rightBtnWording", paramTipsInfo.rightBtnWording);
          paramRichStatus.putString("tips_leftBtnWording", paramTipsInfo.leftBtnWording);
          paramRichStatus.putString("tips_vipType", paramTipsInfo.vipType);
          paramRichStatus.putInt("tips_vipMonth", paramTipsInfo.vipMonth);
          paramRichStatus.putString("tips_url", paramTipsInfo.url);
          paramRichStatus.putInt("authAppid", paramTipsInfo.authAppid);
        }
      }
      paramRichStatus = EIPCResult.createResult(0, paramRichStatus);
      callbackResult(this.r.get(), paramRichStatus);
      this.r.set(0);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetHistorySigNum result = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("Signature", 2, ((StringBuilder)localObject).toString());
    }
    if (this.r.get() > 0)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("notify_type", 9);
      ((Bundle)localObject).putInt("result", paramInt1);
      ((Bundle)localObject).putInt("key_history_signature_num", paramInt2);
      localObject = EIPCResult.createResult(0, (Bundle)localObject);
      callbackResult(this.r.get(), (EIPCResult)localObject);
      this.r.set(0);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if ((this.t.get() > 0) && (this.s.get() > 0) && (paramInt1 == 102) && (paramInt2 == 300) && (BaseApplicationImpl.getApplication() != null) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)))
    {
      ActionInfo localActionInfo = ((StatusManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.STATUS_MANAGER)).a(this.t.get());
      if (localActionInfo != null)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("notify_type", 6);
        ((Bundle)localObject).putString("url", localActionInfo.d);
        ((Bundle)localObject).putInt("id", this.t.get());
        localObject = EIPCResult.createResult(0, (Bundle)localObject);
        callbackResult(this.s.get(), (EIPCResult)localObject);
        this.s.set(0);
        this.t.set(0);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("IPC get action callback id = ");
          ((StringBuilder)localObject).append(this.t.get());
          ((StringBuilder)localObject).append(" url = ");
          ((StringBuilder)localObject).append(localActionInfo.d);
          QLog.d("Signature", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCall action = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("VasFontIPCModule", 2, ((StringBuilder)localObject).toString());
    }
    if ((BaseApplicationImpl.getApplication() != null) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)))
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (a.equals(paramString))
      {
        ThreadManagerV2.executeOnSubThread(new VasFontIPCModule.1(this, paramInt, (QQAppInterface)localObject), true);
      }
      else
      {
        int i1;
        if (c.equals(paramString))
        {
          i1 = paramBundle.getInt("id");
          int i2 = paramBundle.getInt("font_type");
          ((IFontManagerService)((QQAppInterface)localObject).getRuntimeService(IFontManagerService.class, "")).startDownload(i1, Integer.toString(paramInt), i2);
        }
        else if (b.equals(paramString))
        {
          paramString = new StringBuilder();
          paramString.append(VasSoUtils.a());
          paramString.append("libFounderColorFont_818.so");
          if (new File(paramString.toString()).exists())
          {
            callbackResult(paramInt, EIPCResult.createResult(0, null));
          }
          else
          {
            this.o.add(Integer.valueOf(paramInt));
            if (this.q.compareAndSet(false, true)) {
              ((IVasQuickUpdateService)((QQAppInterface)localObject).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "libColorFont_818", "VasFontIPCModule");
            }
          }
        }
        else if (d.equals(paramString))
        {
          i1 = paramBundle.getInt("id");
          if ((i1 > 0) && (!this.u.containsKey(Integer.valueOf(i1))))
          {
            this.u.put(Integer.valueOf(i1), Integer.valueOf(paramInt));
            paramString = new StringBuilder();
            paramString.append("signature.item.");
            paramString.append(i1);
            paramString.append(".json");
            paramString = paramString.toString();
            paramBundle = (IVasQuickUpdateService)((QQAppInterface)localObject).getRuntimeService(IVasQuickUpdateService.class, "");
            paramBundle.addCallBacker(this.w);
            paramBundle.downloadItem(1000L, paramString, "VasFontIPCModule");
          }
        }
        else if (e.equals(paramString))
        {
          paramString = ((StatusManager)((QQAppInterface)localObject).getManager(QQManagerFactory.STATUS_MANAGER)).b(true);
          paramBundle = new Bundle();
          paramBundle.putInt("notify_type", 4);
          paramBundle.putSerializable("my_signature", paramString);
          callbackResult(paramInt, EIPCResult.createResult(0, paramBundle));
        }
        else
        {
          long l1;
          if (f.equals(paramString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Signature", 2, "ACTION_CHANGE_STATUS");
            }
            this.r.set(paramInt);
            paramString = paramBundle.getSerializable("my_signature");
            if ((paramString instanceof RichStatus))
            {
              paramString = (RichStatus)paramString;
              ((StatusManager)((QQAppInterface)localObject).getManager(QQManagerFactory.STATUS_MANAGER)).a(paramString, 0);
            }
            else
            {
              QLog.e("VasFontIPCModule", 1, "change status error, status is null");
              new Bundle().putInt("notify_type", 5);
              callbackResult(paramInt, EIPCResult.createResult(-102, null));
            }
          }
          else if (g.equals(paramString))
          {
            i1 = paramBundle.getInt("id");
            paramString = ((StatusManager)((QQAppInterface)localObject).getManager(QQManagerFactory.STATUS_MANAGER)).a(i1);
            if (paramString == null)
            {
              this.s.set(paramInt);
              this.t.set(i1);
              if (QLog.isColorLevel())
              {
                paramString = new StringBuilder();
                paramString.append("IPC get action fail, wait for callback id = ");
                paramString.append(i1);
                QLog.d("Signature", 2, paramString.toString());
              }
            }
            else
            {
              paramBundle = new Bundle();
              paramBundle.putInt("notify_type", 6);
              paramBundle.putString("url", paramString.d);
              paramBundle.putInt("id", i1);
              callbackResult(paramInt, EIPCResult.createResult(0, paramBundle));
              if (QLog.isColorLevel())
              {
                paramBundle = new StringBuilder();
                paramBundle.append("IPC get action success id = ");
                paramBundle.append(i1);
                paramBundle.append(" url = ");
                paramBundle.append(paramString.d);
                QLog.d("Signature", 2, paramBundle.toString());
              }
            }
          }
          else if (h.equals(paramString))
          {
            l1 = paramBundle.getLong("bid");
            paramString = paramBundle.getString("scid");
            if (TextUtils.isEmpty(paramString))
            {
              callbackResult(paramInt, EIPCResult.createResult(-102, null));
            }
            else if (this.v.containsKey(paramString))
            {
              paramBundle = new Bundle();
              paramBundle.putInt("notify_type", 8);
              paramBundle.putLong("bid", l1);
              paramBundle.putString("scid", paramString);
              paramBundle.putInt("download_result", 1);
              callbackResult(paramInt, EIPCResult.createResult(0, paramBundle));
            }
            else
            {
              this.v.put(paramString, Integer.valueOf(paramInt));
              paramBundle = (IVasQuickUpdateService)((QQAppInterface)localObject).getRuntimeService(IVasQuickUpdateService.class, "");
              paramBundle.addCallBacker(this.w);
              paramBundle.downloadItem(l1, paramString, "VasFontIPCModule");
            }
          }
          else
          {
            if (!i.equals(paramString)) {
              break label986;
            }
            paramString = new Bundle();
            paramString.putInt("key_shield_font", VasShieldFont.b);
            callbackResult(paramInt, EIPCResult.createResult(0, paramString));
          }
          for (;;)
          {
            return null;
            label986:
            if (j.equals(paramString))
            {
              l1 = paramBundle.getLong("key_current_uin");
              this.r.set(paramInt);
              ((StatusManager)((QQAppInterface)localObject).getManager(QQManagerFactory.STATUS_MANAGER)).a(l1);
            }
            else if (k.equals(paramString))
            {
              GLDrawableDownloadHelper.a(true);
            }
            else if (l.equals(paramString))
            {
              QqValueGetValueHandler.a();
            }
            else if (QLog.isColorLevel())
            {
              paramBundle = new StringBuilder();
              paramBundle.append("onCall action = ");
              paramBundle.append(paramString);
              QLog.d("VasFontIPCModule", 2, paramBundle.toString());
            }
          }
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.VasFontIPCModule
 * JD-Core Version:    0.7.0.1
 */