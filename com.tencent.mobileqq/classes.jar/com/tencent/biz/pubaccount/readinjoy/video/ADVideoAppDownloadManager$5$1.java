package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import bdgv;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.List;
import qjf;
import qjg;
import qjh;

public class ADVideoAppDownloadManager$5$1
  implements Runnable
{
  public ADVideoAppDownloadManager$5$1(qjg paramqjg, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_Qjg.a.a.iterator();
    qjf localqjf;
    label233:
    do
    {
      int j;
      int i;
      while (((Iterator)localObject1).hasNext())
      {
        localqjf = (qjf)((Iterator)localObject1).next();
        Object localObject2 = localqjf.c;
        j = this.jdField_a_of_type_Qjg.a.a(localqjf);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (((String)localObject2).equals(this.jdField_a_of_type_JavaLangString)) && ((j == 0) || (j == 4) || (j == 3)))
        {
          localObject2 = bdgv.a().a((String)localObject2);
          i = 0;
          if (localObject2 != null) {
            i = (int)((float)((TMAssistantDownloadTaskInfo)localObject2).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject2).mTotalDataLen * 100.0F);
          }
          if ((j != 3) || (this.jdField_a_of_type_Int != 3)) {
            break label233;
          }
          this.jdField_a_of_type_Qjg.a.c(localqjf);
          localObject1 = new DownloadInfo();
          ((DownloadInfo)localObject1).e = localqjf.d;
          ((DownloadInfo)localObject1).f = i;
          ((DownloadInfo)localObject1).c = localqjf.jdField_a_of_type_JavaLangString;
          ADVideoAppDownloadManager.a(this.jdField_a_of_type_Qjg.a).a = true;
          ADVideoAppDownloadManager.a(this.jdField_a_of_type_Qjg.a).a();
          this.jdField_a_of_type_Qjg.a.a((DownloadInfo)localObject1, 4);
        }
      }
      return;
      if ((j == 4) && ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 1)))
      {
        this.jdField_a_of_type_Qjg.a.a(localqjf);
        localObject1 = new DownloadInfo();
        ((DownloadInfo)localObject1).e = localqjf.d;
        ((DownloadInfo)localObject1).f = i;
        ((DownloadInfo)localObject1).c = localqjf.jdField_a_of_type_JavaLangString;
        ADVideoAppDownloadManager.a(this.jdField_a_of_type_Qjg.a).a = true;
        ADVideoAppDownloadManager.a(this.jdField_a_of_type_Qjg.a).a();
        this.jdField_a_of_type_Qjg.a.a((DownloadInfo)localObject1, 3);
        return;
      }
    } while (this.jdField_a_of_type_Int != 4);
    localObject1 = new DownloadInfo();
    ((DownloadInfo)localObject1).e = localqjf.d;
    ((DownloadInfo)localObject1).f = 100;
    ((DownloadInfo)localObject1).c = localqjf.jdField_a_of_type_JavaLangString;
    ADVideoAppDownloadManager.a(this.jdField_a_of_type_Qjg.a).a = true;
    ADVideoAppDownloadManager.a(this.jdField_a_of_type_Qjg.a).a();
    this.jdField_a_of_type_Qjg.a.a((DownloadInfo)localObject1, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.5.1
 * JD-Core Version:    0.7.0.1
 */