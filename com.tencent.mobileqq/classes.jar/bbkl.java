import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder;
import com.tencent.qphone.base.util.QLog;

public class bbkl
{
  private volatile int jdField_a_of_type_Int = 0;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private void a(bbkn parambbkn, bbmc parambbmc)
  {
    int i = 1;
    boolean bool1 = parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish;
    if (parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 1)
    {
      boolean bool2 = parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("is_hw_encode", false);
      if ((!bool1) && (bool2)) {
        break label50;
      }
    }
    label50:
    do
    {
      return;
      i = 0;
      break;
      if ((i != 0) || (parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 9))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MergeEditVideo", 2, "adjust encode config orientation:" + parambbmc.toString());
        }
        parambbmc.g = 0;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + parambbmc.toString());
  }
  
  public int a(String arg1, String paramString2, bbkn parambbkn)
  {
    if ((parambbkn == null) || (parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null)) {
      i = -1;
    }
    String str;
    Object localObject;
    do
    {
      return i;
      str = parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("subtitleData", "");
      localObject = new bdec();
      j = bdeb.a(???, (bdec)localObject);
      i = j;
    } while (j != 0);
    int k = localObject.a[0];
    int m = localObject.a[1];
    int n = localObject.a[2];
    int i = localObject.a[4];
    int i1 = parambbkn.jdField_a_of_type_Int;
    int j = 0;
    i = j;
    if (!parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish)
    {
      i = j;
      if (parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("is_hw_encode", false))
      {
        i = j;
        if (parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 1)
        {
          i = j;
          if (n != 0) {
            i = 1;
          }
        }
      }
    }
    if ((parambbkn.c == 0) && (parambbkn.b == 0) && (parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath == null) && (parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath == null) && (parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 9) && (TextUtils.isEmpty(str)) && (!parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments) && (TextUtils.isEmpty(parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fragments)) && (i == 0)) {
      return -1;
    }
    boolean bool = parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("enable_flow_decode", true);
    QLog.d("MergeEditVideo", 2, "mergeVideo. enableFlowDecode = " + bool + ", speedMode = " + parambbkn.c);
    j = parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart;
    i = parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd;
    if ((!bool) && (parambbkn.c == 3))
    {
      ??? = parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 0;
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 0;
      if ((bool) && (parambbkn.c == 3))
      {
        localObject = new Mp4FlowReEncoder();
        arrayOfInt[0] = 1;
      }
      for (;;)
      {
        bbko localbbko = new bbko(???, parambbkn.c, false, true, j, i);
        if (((parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 10) && ((n == 270) || (n == 90))) || ((parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 12) && ((n == 270) || (n == 90))))
        {
          ??? = new bbmc(paramString2, m, k, i1, 1, 30, parambbkn.b, false, 0, parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, str, false);
          ???.i = n;
          localbbko.c = true;
          a(parambbkn, ???);
          localbbko.b = n;
          ???.j = parambbkn.d;
          ???.k = parambbkn.e;
          ((bblm)localObject).a(localbbko, ???, new bbkm(this, arrayOfInt), null);
          if (this.jdField_a_of_type_Boolean) {}
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          bool = this.jdField_a_of_type_Boolean;
          if (!bool) {}
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait();
            return this.jdField_a_of_type_Int;
            localObject = new bbmg();
            arrayOfInt[0] = 2;
            continue;
            ??? = new bbmc(paramString2, k, m, i1, 1, 30, parambbkn.b, false, n, parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, parambbkn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, str, false);
          }
          catch (InterruptedException paramString2)
          {
            for (;;)
            {
              paramString2.printStackTrace();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkl
 * JD-Core Version:    0.7.0.1
 */