package com.tencent.mobileqq.apollo.process.download;

import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.utils.VipUtils;

class CmGameRscDownloader$3
  implements CmGameStartChecker.ICmGameConfirmListener
{
  CmGameRscDownloader$3(CmGameRscDownloader paramCmGameRscDownloader) {}
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    CmGameRscDownloader localCmGameRscDownloader = this.a;
    if (CmGameRscDownloader.a(this.a).jdField_b_of_type_Boolean)
    {
      paramStartCheckParam = CmGameRscDownloader.a(this.a).e;
      CmGameRscDownloader.a(localCmGameRscDownloader, paramStartCheckParam);
      if (!"message".equals(CmGameRscDownloader.a(this.a).f)) {
        break label101;
      }
    }
    label101:
    for (int i = 1;; i = 0)
    {
      VipUtils.a(null, "cmshow", "Apollo", "download_confirm", i, 3, new String[] { String.valueOf(CmGameRscDownloader.a(this.a).jdField_b_of_type_Int) });
      return;
      paramStartCheckParam = CmGameRscDownloader.a(this.a).d;
      break;
    }
  }
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (CmGameRscDownloader.a(this.a) != null) {
      CmGameRscDownloader.a(this.a).c(-10001, CmGameRscDownloader.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.download.CmGameRscDownloader.3
 * JD-Core Version:    0.7.0.1
 */