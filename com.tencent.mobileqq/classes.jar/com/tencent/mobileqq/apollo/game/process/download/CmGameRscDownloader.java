package com.tencent.mobileqq.apollo.game.process.download;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.game.ApolloGameResManager;
import com.tencent.mobileqq.apollo.game.ApolloGameTool;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.utils.ApolloResDownloaderUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class CmGameRscDownloader
{
  public DownloadListener a = new CmGameRscDownloader.4(this);
  private CmGameRscSvrInfo b;
  private ICmGameRscDownloadListener c;
  private int d;
  
  public CmGameRscDownloader(CmGameRscSvrInfo paramCmGameRscSvrInfo, ICmGameRscDownloadListener paramICmGameRscDownloadListener)
  {
    this.b = paramCmGameRscSvrInfo;
    this.c = paramICmGameRscDownloadListener;
  }
  
  private void a(int paramInt)
  {
    Object localObject = CmGameUtil.a(paramInt);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleLoadSubpack], launcher is null, mGameId:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("cmgame_process.CmGameRscDownloader", 1, ((StringBuilder)localObject).toString());
      return;
    }
    localObject = ((CmGameLauncher)localObject).a();
    if (localObject != null) {
      ((CmGameSubRscHandler)localObject).a();
    }
  }
  
  private void a(String paramString)
  {
    Object localObject1 = CmGameUtil.b();
    if (localObject1 != null)
    {
      Object localObject2 = this.b;
      if (localObject2 == null) {
        return;
      }
      CmGameUtil.c(((CmGameRscSvrInfo)localObject2).g);
      localObject2 = ApolloResDownloaderUtil.a((AppRuntime)localObject1);
      if (localObject2 == null)
      {
        QLog.e("cmgame_process.CmGameRscDownloader", 1, "updateGameRes no downloaderInterface");
        return;
      }
      localObject1 = DeviceInfoUtil.q();
      if ((localObject1 != null) && (localObject1.length == 2) && (localObject1[1] <= 50L))
      {
        ApolloItemBuilder.a(HardCodeUtil.a(2131900310), 1, BaseApplicationImpl.getContext());
        QLog.w("cmgame_process.CmGameRscDownloader", 2, "updateGameRes:available space on SD card is less than 50M. ====> Stop download game rsc.");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      localStringBuilder.append(this.b.h);
      if (this.b.b) {
        localObject1 = ".patch";
      } else {
        localObject1 = ".zip";
      }
      localStringBuilder.append((String)localObject1);
      paramString = new DownloadTask(paramString, new File(localStringBuilder.toString()));
      paramString.N = true;
      paramString.D = false;
      paramString.J = true;
      paramString.T = false;
      paramString.P = true;
      paramString.Q = true;
      paramString.m = true;
      paramString.L = "apollo_res";
      localObject1 = new Bundle();
      ((DownloaderInterface)localObject2).startDownload(paramString, this.a, (Bundle)localObject1);
      int j = this.b.m;
      int i;
      if ((j != 2) && (j != 1)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((j != 4) && (j != 5) && (j != 3)) {
        break label295;
      }
      j = 1;
      label295:
      this.d = 1;
      VipUtils.a(null, "cmshow", "Apollo", "game_renew_start", i, j, new String[] { String.valueOf(this.b.g), String.valueOf(this.b.c), this.b.i, String.valueOf(this.b.o) });
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameRscDownloader", 2, "[doOnGameResFileDone]");
    }
    if (this.b == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[game_launch_cost], download rsc:");
    ((StringBuilder)localObject1).append(System.currentTimeMillis() - this.b.p);
    QLog.i("cmgame_process.CmGameRscDownloader", 1, ((StringBuilder)localObject1).toString());
    boolean bool = this.b.b;
    Object localObject3 = this.b.j;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
    ((StringBuilder)localObject1).append(this.b.h);
    ((StringBuilder)localObject1).append(".zip");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4);
    try
    {
      localObject4 = ((SharedPreferences)localObject2).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_sp_game_rsc_verify_");
      localStringBuilder.append(this.b.h);
      ((SharedPreferences.Editor)localObject4).putBoolean(localStringBuilder.toString(), false).commit();
      if (bool)
      {
        bool = ApolloGameResManager.a(String.valueOf(this.b.h), (String)localObject3);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[game_launch_cost], patch rsc:");
        ((StringBuilder)localObject3).append(System.currentTimeMillis() - this.b.p);
        QLog.i("cmgame_process.CmGameRscDownloader", 1, ((StringBuilder)localObject3).toString());
        if (!bool)
        {
          QLog.e("cmgame_process.CmGameRscDownloader", 1, "fail to patch, download complete pack.");
          this.b.b = false;
          a(this.b.k);
          return;
        }
      }
      if (this.c != null) {
        FileUtils.uncompressZip((String)localObject1, this.c.a(this.b.g, this.b.i), false);
      }
      ApolloGameTool.b();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[game_launch_cost], unzip rsc:");
      ((StringBuilder)localObject3).append(System.currentTimeMillis() - this.b.p);
      QLog.i("cmgame_process.CmGameRscDownloader", 1, ((StringBuilder)localObject3).toString());
      a(this.b.g);
      if (this.c != null) {
        this.c.c(this.b.g, this.b.i);
      }
      this.d = 0;
      if (!this.b.b)
      {
        VipUtils.a(null, "cmshow", "Apollo", "game_renew_succeed", 0, this.b.m, new String[] { String.valueOf(this.b.g), String.valueOf(this.b.c), this.b.i, String.valueOf(this.b.o) });
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("uncompressZip fail zip file: ");
      ((StringBuilder)localObject4).append((String)localObject1);
      QLog.e("cmgame_process.CmGameRscDownloader", 1, ((StringBuilder)localObject4).toString(), localException);
      localObject1 = ((SharedPreferences)localObject2).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("apollo_sp_game_rsc_verify_");
      ((StringBuilder)localObject2).append(this.b.h);
      ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), true).commit();
      localObject1 = this.c;
      if (localObject1 != null) {
        ((ICmGameRscDownloadListener)localObject1).d(-1006, this.b.i);
      }
    }
  }
  
  public int a()
  {
    return this.d;
  }
  
  public boolean b()
  {
    if (this.b == null) {
      return false;
    }
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_sp_game_rsc_verify_");
    localStringBuilder.append(this.b.h);
    boolean bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isVerifyFail:");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(",isUpdate:");
    ((StringBuilder)localObject).append(this.b.a);
    ((StringBuilder)localObject).append(",isPatch:");
    ((StringBuilder)localObject).append(this.b.b);
    ((StringBuilder)localObject).append("packType:");
    ((StringBuilder)localObject).append(this.b.o);
    ((StringBuilder)localObject).append(",delay:");
    ((StringBuilder)localObject).append(this.b.q);
    QLog.i("cmgame_process.CmGameRscDownloader", 1, ((StringBuilder)localObject).toString());
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameRscDownloader", 2, new Object[] { "patchUrl:", this.b.l });
    }
    if ((!bool) && (!this.b.a)) {
      return false;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new CmGameRscDownloader.1(this), this.b.q);
    return true;
  }
  
  public void c()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.download.CmGameRscDownloader
 * JD-Core Version:    0.7.0.1
 */