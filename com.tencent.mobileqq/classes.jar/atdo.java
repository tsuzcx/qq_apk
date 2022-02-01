import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atdo
  implements View.OnClickListener
{
  public atdo(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    FileInfo localFileInfo;
    if ((localObject1 instanceof atdw))
    {
      localObject1 = (atdw)paramView.getTag();
      localFileInfo = (FileInfo)((atdw)localObject1).jdField_a_of_type_JavaLangObject;
      localObject1 = ((atdw)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131366742) && (QfileBaseLocalFileTabView.b(this.a))) {
        bdla.b(QfileBaseLocalFileTabView.b(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      Object localObject2;
      if (localFileInfo != null)
      {
        localObject2 = this.a;
        if (paramView.getId() != 2131366742) {
          break label245;
        }
      }
      label245:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseLocalFileTabView)localObject2).a(localFileInfo, (View)localObject1, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!(localObject1 instanceof ataa)) {
          break label250;
        }
        localObject2 = (ataa)paramView.getTag();
        localFileInfo = (FileInfo)((ataa)localObject2).jdField_a_of_type_JavaLangObject;
        localObject1 = ((ataa)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
        if ((this.a.a.g()) || (this.a.a.h()))
        {
          SharedPreferences.Editor localEditor = this.a.a.getSharedPreferences("LAST_CHOOSE_", 0).edit();
          localEditor.putInt("GROUP", ((ataa)localObject2).b);
          localEditor.putInt("CHILD", (((ataa)localObject2).jdField_a_of_type_Int + 1) / 4);
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
 * Qualified Name:     atdo
 * JD-Core Version:    0.7.0.1
 */