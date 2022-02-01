import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asxn
  implements View.OnClickListener
{
  public asxn(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    FileManagerEntity localFileManagerEntity;
    int i;
    if ((localObject1 instanceof asyb))
    {
      localObject2 = (asyb)paramView.getTag();
      localObject1 = ((asyb)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
      localFileManagerEntity = (FileManagerEntity)((asyb)localObject2).jdField_a_of_type_JavaLangObject;
      i = ((asyb)localObject2).b;
      i = ((asyb)localObject2).c;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131366555) && (QfileBaseRecentFileTabView.b(this.a))) {
        bcst.b(QfileBaseRecentFileTabView.s(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (localFileManagerEntity != null)
      {
        localObject2 = this.a;
        if (paramView.getId() != 2131366555) {
          break label190;
        }
      }
      label190:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseRecentFileTabView)localObject2).a(localFileManagerEntity, (View)localObject1, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!(localObject1 instanceof asth)) {
          break label195;
        }
        localObject2 = (asth)paramView.getTag();
        localObject1 = ((asth)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
        localFileManagerEntity = (FileManagerEntity)((asth)localObject2).jdField_a_of_type_JavaLangObject;
        i = ((asth)localObject2).b;
        i = ((asth)localObject2).jdField_a_of_type_Int;
        break;
      }
      label195:
      localObject1 = null;
      localFileManagerEntity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxn
 * JD-Core Version:    0.7.0.1
 */