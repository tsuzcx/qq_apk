import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder;
import com.tencent.qphone.base.util.QLog;

public class bbkv
{
  private volatile int jdField_a_of_type_Int = 0;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private void a(bbkx parambbkx, bbmm parambbmm)
  {
    int i = 1;
    boolean bool1 = parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish;
    if (parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 1)
    {
      boolean bool2 = parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("is_hw_encode", false);
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
      if ((i != 0) || (parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 9))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MergeEditVideo", 2, "adjust encode config orientation:" + parambbmm.toString());
        }
        parambbmm.g = 0;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + parambbmm.toString());
  }
  
  public int a(String arg1, String paramString2, bbkx parambbkx)
  {
    if ((parambbkx == null) || (parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null)) {
      i = -1;
    }
    String str;
    Object localObject;
    do
    {
      return i;
      str = parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("subtitleData", "");
      localObject = new bddw();
      j = bddv.a(???, (bddw)localObject);
      i = j;
    } while (j != 0);
    int k = localObject.a[0];
    int m = localObject.a[1];
    int n = localObject.a[2];
    int i = localObject.a[4];
    int i1 = parambbkx.jdField_a_of_type_Int;
    int j = 0;
    i = j;
    if (!parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish)
    {
      i = j;
      if (parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("is_hw_encode", false))
      {
        i = j;
        if (parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 1)
        {
          i = j;
          if (n != 0) {
            i = 1;
          }
        }
      }
    }
    if ((parambbkx.c == 0) && (parambbkx.b == 0) && (parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath == null) && (parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath == null) && (parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 9) && (TextUtils.isEmpty(str)) && (!parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments) && (TextUtils.isEmpty(parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fragments)) && (i == 0)) {
      return -1;
    }
    boolean bool = parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("enable_flow_decode", true);
    QLog.d("MergeEditVideo", 2, "mergeVideo. enableFlowDecode = " + bool + ", speedMode = " + parambbkx.c);
    j = parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart;
    i = parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd;
    if ((!bool) && (parambbkx.c == 3))
    {
      ??? = parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 0;
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 0;
      if ((bool) && (parambbkx.c == 3))
      {
        localObject = new Mp4FlowReEncoder();
        arrayOfInt[0] = 1;
      }
      for (;;)
      {
        bbky localbbky = new bbky(???, parambbkx.c, false, true, j, i);
        if (((parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 10) && ((n == 270) || (n == 90))) || ((parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 12) && ((n == 270) || (n == 90))))
        {
          ??? = new bbmm(paramString2, m, k, i1, 1, 30, parambbkx.b, false, 0, parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, str, false);
          ???.i = n;
          localbbky.c = true;
          a(parambbkx, ???);
          localbbky.b = n;
          ???.j = parambbkx.d;
          ???.k = parambbkx.e;
          ((bblw)localObject).a(localbbky, ???, new bbkw(this, arrayOfInt), null);
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
            localObject = new bbmq();
            arrayOfInt[0] = 2;
            continue;
            ??? = new bbmm(paramString2, k, m, i1, 1, 30, parambbkx.b, false, n, parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, parambbkx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, str, false);
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
 * Qualified Name:     bbkv
 * JD-Core Version:    0.7.0.1
 */