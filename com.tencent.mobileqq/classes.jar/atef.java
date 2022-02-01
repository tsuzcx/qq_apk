import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atef
  implements View.OnClickListener
{
  public atef(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "qfilebaserecenttabview del error, tag is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.getTag();
      if (localFileManagerEntity != null)
      {
        if (this.a.jdField_a_of_type_Atab != null) {
          this.a.jdField_a_of_type_Atab.a(null);
        }
        this.a.jdField_a_of_type_Long = localFileManagerEntity.nSessionId;
        if (QfileBaseRecentFileTabView.m(this.a).getFileManagerEngine().b(this.a.jdField_a_of_type_Long)) {
          this.a.a(localFileManagerEntity);
        }
      }
      this.a.jdField_a_of_type_Atab.a(Integer.valueOf(-1));
      paramView.setVisibility(4);
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atef
 * JD-Core Version:    0.7.0.1
 */