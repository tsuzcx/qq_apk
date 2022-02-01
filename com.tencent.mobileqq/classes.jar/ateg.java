import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ateg
  implements View.OnClickListener
{
  public ateg(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    FileManagerEntity localFileManagerEntity;
    int i;
    if ((localObject1 instanceof ateu))
    {
      localObject2 = (ateu)paramView.getTag();
      localObject1 = ((ateu)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
      localFileManagerEntity = (FileManagerEntity)((ateu)localObject2).jdField_a_of_type_JavaLangObject;
      i = ((ateu)localObject2).b;
      i = ((ateu)localObject2).c;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131366742) && (QfileBaseRecentFileTabView.b(this.a))) {
        bdla.b(QfileBaseRecentFileTabView.s(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (localFileManagerEntity != null)
      {
        localObject2 = this.a;
        if (paramView.getId() != 2131366742) {
          break label190;
        }
      }
      label190:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseRecentFileTabView)localObject2).a(localFileManagerEntity, (View)localObject1, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!(localObject1 instanceof ataa)) {
          break label195;
        }
        localObject2 = (ataa)paramView.getTag();
        localObject1 = ((ataa)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
        localFileManagerEntity = (FileManagerEntity)((ataa)localObject2).jdField_a_of_type_JavaLangObject;
        i = ((ataa)localObject2).b;
        i = ((ataa)localObject2).jdField_a_of_type_Int;
        break;
      }
      label195:
      localObject1 = null;
      localFileManagerEntity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ateg
 * JD-Core Version:    0.7.0.1
 */