import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder;
import com.tencent.qphone.base.util.QLog;

public class avxj
{
  private volatile int jdField_a_of_type_Int = 0;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private void a(avxl paramavxl, avza paramavza)
  {
    int i = 1;
    boolean bool1 = paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish;
    if (paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 1)
    {
      boolean bool2 = paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("is_hw_encode", false);
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
      if ((i != 0) || (paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 9))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MergeEditVideo", 2, "adjust encode config orientation:" + paramavza.toString());
        }
        paramavza.g = 0;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + paramavza.toString());
  }
  
  public int a(String arg1, String paramString2, avxl paramavxl)
  {
    if ((paramavxl == null) || (paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null)) {
      i = -1;
    }
    String str;
    Object localObject;
    do
    {
      return i;
      str = paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("subtitleData", "");
      localObject = new axkw();
      j = axkv.a(???, (axkw)localObject);
      i = j;
    } while (j != 0);
    int k = localObject.a[0];
    int m = localObject.a[1];
    int n = localObject.a[2];
    int i = localObject.a[4];
    int i1 = paramavxl.jdField_a_of_type_Int;
    int j = 0;
    i = j;
    if (!paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish)
    {
      i = j;
      if (paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("is_hw_encode", false))
      {
        i = j;
        if (paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 1)
        {
          i = j;
          if (n != 0) {
            i = 1;
          }
        }
      }
    }
    if ((paramavxl.c == 0) && (paramavxl.b == 0) && (paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath == null) && (paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath == null) && (paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 9) && (TextUtils.isEmpty(str)) && (!paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments) && (TextUtils.isEmpty(paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fragments)) && (i == 0)) {
      return -1;
    }
    boolean bool = paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("enable_flow_decode", true);
    QLog.d("MergeEditVideo", 2, "mergeVideo. enableFlowDecode = " + bool + ", speedMode = " + paramavxl.c);
    j = paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart;
    i = paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd;
    if ((!bool) && (paramavxl.c == 3))
    {
      ??? = paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 0;
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 0;
      if ((bool) && (paramavxl.c == 3))
      {
        localObject = new Mp4FlowReEncoder();
        arrayOfInt[0] = 1;
      }
      for (;;)
      {
        avxm localavxm = new avxm(???, paramavxl.c, false, true, j, i);
        if (((paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 10) && ((n == 270) || (n == 90))) || ((paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 12) && ((n == 270) || (n == 90))))
        {
          ??? = new avza(paramString2, m, k, i1, 1, 30, paramavxl.b, false, 0, paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, str, false);
          ???.i = n;
          localavxm.c = true;
          a(paramavxl, ???);
          localavxm.b = n;
          ???.j = paramavxl.d;
          ???.k = paramavxl.e;
          ((avyk)localObject).a(localavxm, ???, new avxk(this, arrayOfInt), null);
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
            localObject = new avze();
            arrayOfInt[0] = 2;
            continue;
            ??? = new avza(paramString2, k, m, i1, 1, 30, paramavxl.b, false, n, paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, paramavxl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, str, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avxj
 * JD-Core Version:    0.7.0.1
 */