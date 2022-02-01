import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class bpoy
  extends bpor
{
  private bpor jdField_a_of_type_Bpor;
  private ConcurrentHashMap<String, MusicItemInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap<String, bihu> b;
  
  public bpoy(ConcurrentHashMap<String, MusicItemInfo> paramConcurrentHashMap, ConcurrentHashMap<String, bihu> paramConcurrentHashMap1, bpor parambpor)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    this.b = paramConcurrentHashMap1;
    this.jdField_a_of_type_Bpor = parambpor;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bpor.a(paramInt);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicDownloadListener", 2, "onCancel key=" + paramString);
    }
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localMusicItemInfo != null) {
      localMusicItemInfo.mProgress = -1;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    this.b.remove(paramString);
    this.jdField_a_of_type_Bpor.a(paramString);
    bpvy.a(localMusicItemInfo).c();
  }
  
  public void a(String paramString, int paramInt)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    int i = paramInt;
    if (localMusicItemInfo != null)
    {
      i = paramInt;
      if (paramInt == 100)
      {
        i = paramInt;
        if (this.b.contains(localMusicItemInfo.getLocalPath())) {
          i = 99;
        }
      }
      localMusicItemInfo.mProgress = i;
    }
    this.jdField_a_of_type_Bpor.a(paramString, i);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localMusicItemInfo != null)
    {
      if (paramBoolean) {
        break label60;
      }
      bpvy.a(localMusicItemInfo).c();
      localMusicItemInfo.mProgress = -1;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      this.b.remove(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bpor.a(paramString, paramBoolean);
      return;
      label60:
      localMusicItemInfo.mProgress = 1;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicDownloadListener", 2, new Object[] { "onFinish, info:", localMusicItemInfo });
    }
    boolean bool = paramBoolean;
    if (localMusicItemInfo != null)
    {
      if (!paramBoolean) {
        break label214;
      }
      localMusicItemInfo.mProgress = 100;
      bpvy.a(localMusicItemInfo).b();
      bool = paramBoolean;
      if (localMusicItemInfo.isMyMusicInfo())
      {
        bool = paramBoolean;
        if (localMusicItemInfo.fileSize > 0L)
        {
          File localFile = new File(paramString);
          if (localFile.length() != localMusicItemInfo.fileSize)
          {
            localMusicItemInfo.mProgress = -1;
            bpvy.a(localMusicItemInfo).c();
            paramBoolean = false;
          }
          bool = paramBoolean;
          if (QLog.isColorLevel()) {
            QLog.d("QQMusicDownloadListener", 2, "file.length =" + localFile.length() + " info.fileSize=" + localMusicItemInfo.fileSize);
          }
        }
      }
    }
    for (bool = paramBoolean;; bool = paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      this.b.remove(paramString);
      this.jdField_a_of_type_Bpor.a(paramString, bool, paramInt);
      return;
      label214:
      localMusicItemInfo.mProgress = -1;
      bpvy.a(localMusicItemInfo).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpoy
 * JD-Core Version:    0.7.0.1
 */