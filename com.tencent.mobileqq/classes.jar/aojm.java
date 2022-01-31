import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class aojm
  implements INetEngine.INetEngineListener
{
  aojm(aojj paramaojj, File paramFile, WeakReference paramWeakReference1, WeakReference paramWeakReference2, String paramString, WeakReference paramWeakReference3, boolean paramBoolean, aojr paramaojr) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i = (int)(100L * paramLong1 / paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "apng percent:" + i);
    }
    ThreadManager.getUIHandler().post(new aojq(this, i));
  }
  
  public void a(NetResp paramNetResp)
  {
    String str = ((InfomationFacePackage.Item)paramNetResp.a.a()).d;
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "onResp ,url is :" + str + " http status:" + paramNetResp.c);
    }
    bool2 = false;
    bool1 = bool2;
    if (paramNetResp.c == 200)
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    for (;;)
    {
      try
      {
        bool1 = ApngDrawable.isApngFile(this.jdField_a_of_type_JavaIoFile);
        if (!bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (IOException paramNetResp)
      {
        paramNetResp.printStackTrace();
        bool1 = bool2;
        continue;
      }
      ThreadManager.getUIHandler().post(new aojn(this, bool1));
      return;
      this.jdField_a_of_type_JavaIoFile.delete();
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("InformationFaceAdapter", 2, "onResp ,valid apng file");
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aojm
 * JD-Core Version:    0.7.0.1
 */