import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;

public class aqll
  implements View.OnClickListener
{
  public aqll(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    FileInfo localFileInfo;
    if ((localObject1 instanceof aqlt))
    {
      localObject1 = (aqlt)paramView.getTag();
      localFileInfo = (FileInfo)((aqlt)localObject1).jdField_a_of_type_JavaLangObject;
      localObject1 = ((aqlt)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131366299) && (QfileBaseLocalFileTabView.b(this.a))) {
        azmj.b(QfileBaseLocalFileTabView.b(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      Object localObject2;
      if (localFileInfo != null)
      {
        localObject2 = this.a;
        if (paramView.getId() != 2131366299) {
          break label238;
        }
      }
      label238:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseLocalFileTabView)localObject2).a(localFileInfo, (View)localObject1, bool);
        return;
        if (!(localObject1 instanceof aqiy)) {
          break label243;
        }
        localObject2 = (aqiy)paramView.getTag();
        localFileInfo = (FileInfo)((aqiy)localObject2).jdField_a_of_type_JavaLangObject;
        localObject1 = ((aqiy)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
        if ((this.a.a.g()) || (this.a.a.h()))
        {
          SharedPreferences.Editor localEditor = this.a.a.getSharedPreferences("LAST_CHOOSE_", 0).edit();
          localEditor.putInt("GROUP", ((aqiy)localObject2).b);
          localEditor.putInt("CHILD", (((aqiy)localObject2).jdField_a_of_type_Int + 1) / 4);
          localEditor.commit();
        }
        break;
      }
      label243:
      localObject1 = null;
      localFileInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqll
 * JD-Core Version:    0.7.0.1
 */