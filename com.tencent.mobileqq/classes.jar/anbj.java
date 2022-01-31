import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;
import java.io.File;

class anbj
  implements Runnable
{
  anbj(anbi paramanbi, String paramString) {}
  
  public void run()
  {
    try
    {
      EditPicSave.a(this.jdField_a_of_type_Anbi.a, PlusPanelUtils.a());
      File localFile = new File(EditPicSave.a(this.jdField_a_of_type_Anbi.a));
      if (FileUtils.a(new File(this.jdField_a_of_type_JavaLangString), localFile)) {
        ImageUtil.a(this.jdField_a_of_type_Anbi.a.a.getActivity(), localFile);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EditPicSave", 2, "savePic " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anbj
 * JD-Core Version:    0.7.0.1
 */