import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter;
import java.lang.ref.WeakReference;

class aojp
  implements Runnable
{
  aojp(aojo paramaojo) {}
  
  public void run()
  {
    if (this.a.a.a.c.get() != null)
    {
      ((BaseFaceListAdapter)this.a.a.a.c.get()).notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceAdapter", 2, "onResp , ApngSoLoadCallBack!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aojp
 * JD-Core Version:    0.7.0.1
 */