import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atmz
  implements View.OnClickListener
{
  public atmz(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    FileInfo localFileInfo;
    if ((localObject1 instanceof atnh))
    {
      localObject1 = (atnh)paramView.getTag();
      localFileInfo = (FileInfo)((atnh)localObject1).jdField_a_of_type_JavaLangObject;
      localObject1 = ((atnh)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131366604) && (QfileBaseLocalFileTabView.b(this.a))) {
        bdll.b(QfileBaseLocalFileTabView.b(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      Object localObject2;
      if (localFileInfo != null)
      {
        localObject2 = this.a;
        if (paramView.getId() != 2131366604) {
          break label245;
        }
      }
      label245:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseLocalFileTabView)localObject2).a(localFileInfo, (View)localObject1, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!(localObject1 instanceof atjl)) {
          break label250;
        }
        localObject2 = (atjl)paramView.getTag();
        localFileInfo = (FileInfo)((atjl)localObject2).jdField_a_of_type_JavaLangObject;
        localObject1 = ((atjl)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
        if ((this.a.a.g()) || (this.a.a.h()))
        {
          SharedPreferences.Editor localEditor = this.a.a.getSharedPreferences("LAST_CHOOSE_", 0).edit();
          localEditor.putInt("GROUP", ((atjl)localObject2).b);
          localEditor.putInt("CHILD", (((atjl)localObject2).jdField_a_of_type_Int + 1) / 4);
          localEditor.commit();
        }
        break;
      }
      label250:
      localObject1 = null;
      localFileInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmz
 * JD-Core Version:    0.7.0.1
 */