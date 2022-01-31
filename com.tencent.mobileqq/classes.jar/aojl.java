import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter;

class aojl
  implements Runnable
{
  aojl(aojk paramaojk) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.a.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceAdapter", 2, "onResp , local exist ApngSoLoadCallBack!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aojl
 * JD-Core Version:    0.7.0.1
 */