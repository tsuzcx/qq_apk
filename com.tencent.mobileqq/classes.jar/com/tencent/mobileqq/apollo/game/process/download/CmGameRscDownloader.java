package com.tencent.mobileqq.apollo.game.process.download;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class CmGameRscDownloader
{
  private int jdField_a_of_type_Int;
  private CmGameRscSvrInfo jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo;
  private ICmGameRscDownloadListener jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadICmGameRscDownloadListener;
  public DownloadListener a;
  
  public CmGameRscDownloader(CmGameRscSvrInfo paramCmGameRscSvrInfo, ICmGameRscDownloadListener paramICmGameRscDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new CmGameRscDownloader.4(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo = paramCmGameRscSvrInfo;
    this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadICmGameRscDownloadListener = paramICmGameRscDownloadListener;
  }
  
  private void a(int paramInt)
  {
    Object localObject = CmGameUtil.a(paramInt);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleLoadSuppack], launcher is null, mGameId:");
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
    Object localObject2 = CmGameUtil.a();
    if (localObject2 != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo;
      if (localObject1 == null) {
        return;
      }
      CmGameUtil.b(((CmGameRscSvrInfo)localObject1).jdField_b_of_type_Int);
      localObject1 = null;
      localObject2 = (DownloaderFactory)((AppInterface)localObject2).getManager(QQManagerFactory.DOWNLOADER_FACTORY);
      if (localObject2 != null) {
        localObject1 = ((DownloaderFactory)localObject2).a(3);
      }
      if (localObject1 == null)
      {
        QLog.e("cmgame_process.CmGameRscDownloader", 1, "updateGameRes no downloaderInterface");
        return;
      }
      localObject2 = DeviceInfoUtil.b();
      if ((localObject2 != null) && (localObject2.length == 2) && (localObject2[1] <= 50L))
      {
        ApolloItemBuilder.a(HardCodeUtil.a(2131702305), 1, BaseApplicationImpl.getContext());
        QLog.w("cmgame_process.CmGameRscDownloader", 2, "updateGameRes:available space on SD card is less than 50M. ====> Stop download game rsc.");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_Boolean) {
        localObject2 = ".patch";
      } else {
        localObject2 = ".zip";
      }
      localStringBuilder.append((String)localObject2);
      paramString = new DownloadTask(paramString, new File(localStringBuilder.toString()));
      paramString.p = true;
      paramString.j = false;
      paramString.n = true;
      paramString.s = false;
      paramString.q = true;
      paramString.r = true;
      paramString.jdField_b_of_type_Boolean = true;
      paramString.f = "apollo_res";
      localObject2 = new Bundle();
      ((DownloaderInterface)localObject1).startDownload(paramString, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject2);
      int j = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_c_of_type_Int;
      int i;
      if ((j != 2) && (j != 1)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((j != 4) && (j != 5) && (j != 3)) {
        break label317;
      }
      j = 1;
      label317:
      this.jdField_a_of_type_Int = 1;
      VipUtils.a(null, "cmshow", "Apollo", "game_renew_start", i, j, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_d_of_type_Int) });
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameRscDownloader", 2, "[doOnGameResFileDone]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[game_launch_cost], download rsc:");
    ((StringBuilder)localObject1).append(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_c_of_type_Long);
    QLog.i("cmgame_process.CmGameRscDownloader", 1, ((StringBuilder)localObject1).toString());
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_Boolean;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_c_of_type_JavaLangString;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(".zip");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4);
    for (;;)
    {
      try
      {
        localObject4 = ((SharedPreferences)localObject2).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("apollo_sp_game_rsc_verify_");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_a_of_type_JavaLangString);
        ((SharedPreferences.Editor)localObject4).putBoolean(localStringBuilder.toString(), false).commit();
        if (bool)
        {
          bool = CmGameUtil.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_a_of_type_JavaLangString), (String)localObject3);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[game_launch_cost], patch rsc:");
          ((StringBuilder)localObject3).append(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_c_of_type_Long);
          QLog.i("cmgame_process.CmGameRscDownloader", 1, ((StringBuilder)localObject3).toString());
          if (!bool)
          {
            QLog.e("cmgame_process.CmGameRscDownloader", 1, "fail to patch, download complete pack.");
            this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_Boolean = false;
            a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_d_of_type_JavaLangString);
            return;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadICmGameRscDownloadListener != null) {
          FileUtils.uncompressZip((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadICmGameRscDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_JavaLangString), false);
        }
        ApolloUtilImpl.deleteGameResIfNeed();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[game_launch_cost], unzip rsc:");
        ((StringBuilder)localObject3).append(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_c_of_type_Long);
        QLog.i("cmgame_process.CmGameRscDownloader", 1, ((StringBuilder)localObject3).toString());
        a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadICmGameRscDownloadListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadICmGameRscDownloadListener.b(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_JavaLangString);
        }
        this.jdField_a_of_type_Int = 0;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_Boolean) {
          break label655;
        }
        j = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_c_of_type_Int;
        if (j == 2) {
          break label661;
        }
        if (j != 1) {
          break label656;
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
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_a_of_type_JavaLangString);
        ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), true).commit();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadICmGameRscDownloadListener;
        if (localObject1 == null) {
          break label655;
        }
        ((ICmGameRscDownloadListener)localObject1).c(-1006, this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_JavaLangString);
      }
      VipUtils.a(null, "cmshow", "Apollo", "game_renew_succeed", i, j, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_d_of_type_Int) });
      return;
      label655:
      return;
      label656:
      int i = 0;
      break label663;
      label661:
      i = 1;
      label663:
      if ((j != 2) && (j != 5) && (j != 3)) {}
      int j = 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo == null) {
      return false;
    }
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_sp_game_rsc_verify_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_a_of_type_JavaLangString);
    boolean bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isVerifyFail:");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(",isUpdate:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject).append(",isPatch:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_b_of_type_Boolean);
    ((StringBuilder)localObject).append("packType:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_d_of_type_Int);
    ((StringBuilder)localObject).append(",delay:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_e_of_type_Int);
    QLog.i("cmgame_process.CmGameRscDownloader", 1, ((StringBuilder)localObject).toString());
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameRscDownloader", 2, new Object[] { "patchUrl:", this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_e_of_type_JavaLangString });
    }
    if ((!bool) && (!this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_a_of_type_Boolean)) {
      return false;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new CmGameRscDownloader.1(this), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscSvrInfo.jdField_e_of_type_Int);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.download.CmGameRscDownloader
 * JD-Core Version:    0.7.0.1
 */