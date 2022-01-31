import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class aotj
  implements View.OnClickListener
{
  public aotj(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    FileManagerEntity localFileManagerEntity;
    int i;
    if ((localObject1 instanceof aots))
    {
      localObject2 = (aots)paramView.getTag();
      localObject1 = ((aots)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
      localFileManagerEntity = (FileManagerEntity)((aots)localObject2).jdField_a_of_type_JavaLangObject;
      i = ((aots)localObject2).b;
      i = ((aots)localObject2).c;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131366211) && (QfileBaseRecentFileTabView.b(this.a))) {
        axqy.b(QfileBaseRecentFileTabView.s(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (localFileManagerEntity != null)
      {
        localObject2 = this.a;
        if (paramView.getId() != 2131366211) {
          break label183;
        }
      }
      label183:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseRecentFileTabView)localObject2).a(localFileManagerEntity, (View)localObject1, bool);
        return;
        if (!(localObject1 instanceof aoqa)) {
          break label188;
        }
        localObject2 = (aoqa)paramView.getTag();
        localObject1 = ((aoqa)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
        localFileManagerEntity = (FileManagerEntity)((aoqa)localObject2).jdField_a_of_type_JavaLangObject;
        i = ((aoqa)localObject2).b;
        i = ((aoqa)localObject2).jdField_a_of_type_Int;
        break;
      }
      label188:
      localObject1 = null;
      localFileManagerEntity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aotj
 * JD-Core Version:    0.7.0.1
 */