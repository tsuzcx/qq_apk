import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asaa
  implements View.OnClickListener
{
  public asaa(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    FileManagerEntity localFileManagerEntity;
    int i;
    if ((localObject1 instanceof asao))
    {
      localObject2 = (asao)paramView.getTag();
      localObject1 = ((asao)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
      localFileManagerEntity = (FileManagerEntity)((asao)localObject2).jdField_a_of_type_JavaLangObject;
      i = ((asao)localObject2).b;
      i = ((asao)localObject2).c;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131366631) && (QfileBaseRecentFileTabView.b(this.a))) {
        bcef.b(QfileBaseRecentFileTabView.s(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (localFileManagerEntity != null)
      {
        localObject2 = this.a;
        if (paramView.getId() != 2131366631) {
          break label190;
        }
      }
      label190:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseRecentFileTabView)localObject2).a(localFileManagerEntity, (View)localObject1, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!(localObject1 instanceof arvu)) {
          break label195;
        }
        localObject2 = (arvu)paramView.getTag();
        localObject1 = ((arvu)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
        localFileManagerEntity = (FileManagerEntity)((arvu)localObject2).jdField_a_of_type_JavaLangObject;
        i = ((arvu)localObject2).b;
        i = ((arvu)localObject2).jdField_a_of_type_Int;
        break;
      }
      label195:
      localObject1 = null;
      localFileManagerEntity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asaa
 * JD-Core Version:    0.7.0.1
 */