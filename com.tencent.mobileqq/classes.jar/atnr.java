import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atnr
  implements View.OnClickListener
{
  public atnr(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    FileManagerEntity localFileManagerEntity;
    int i;
    if ((localObject1 instanceof atof))
    {
      localObject2 = (atof)paramView.getTag();
      localObject1 = ((atof)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
      localFileManagerEntity = (FileManagerEntity)((atof)localObject2).jdField_a_of_type_JavaLangObject;
      i = ((atof)localObject2).b;
      i = ((atof)localObject2).c;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131366604) && (QfileBaseRecentFileTabView.b(this.a))) {
        bdll.b(QfileBaseRecentFileTabView.s(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (localFileManagerEntity != null)
      {
        localObject2 = this.a;
        if (paramView.getId() != 2131366604) {
          break label190;
        }
      }
      label190:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseRecentFileTabView)localObject2).a(localFileManagerEntity, (View)localObject1, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!(localObject1 instanceof atjl)) {
          break label195;
        }
        localObject2 = (atjl)paramView.getTag();
        localObject1 = ((atjl)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
        localFileManagerEntity = (FileManagerEntity)((atjl)localObject2).jdField_a_of_type_JavaLangObject;
        i = ((atjl)localObject2).b;
        i = ((atjl)localObject2).jdField_a_of_type_Int;
        break;
      }
      label195:
      localObject1 = null;
      localFileManagerEntity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atnr
 * JD-Core Version:    0.7.0.1
 */