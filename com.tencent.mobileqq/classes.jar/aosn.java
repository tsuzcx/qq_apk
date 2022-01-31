import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;

public class aosn
  implements View.OnClickListener
{
  public aosn(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    FileInfo localFileInfo;
    if ((localObject1 instanceof aosv))
    {
      localObject1 = (aosv)paramView.getTag();
      localFileInfo = (FileInfo)((aosv)localObject1).jdField_a_of_type_JavaLangObject;
      localObject1 = ((aosv)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131366211) && (QfileBaseLocalFileTabView.b(this.a))) {
        axqy.b(QfileBaseLocalFileTabView.b(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      Object localObject2;
      if (localFileInfo != null)
      {
        localObject2 = this.a;
        if (paramView.getId() != 2131366211) {
          break label238;
        }
      }
      label238:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseLocalFileTabView)localObject2).a(localFileInfo, (View)localObject1, bool);
        return;
        if (!(localObject1 instanceof aoqa)) {
          break label243;
        }
        localObject2 = (aoqa)paramView.getTag();
        localFileInfo = (FileInfo)((aoqa)localObject2).jdField_a_of_type_JavaLangObject;
        localObject1 = ((aoqa)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
        if ((this.a.a.g()) || (this.a.a.h()))
        {
          SharedPreferences.Editor localEditor = this.a.a.getSharedPreferences("LAST_CHOOSE_", 0).edit();
          localEditor.putInt("GROUP", ((aoqa)localObject2).b);
          localEditor.putInt("CHILD", (((aoqa)localObject2).jdField_a_of_type_Int + 1) / 4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosn
 * JD-Core Version:    0.7.0.1
 */