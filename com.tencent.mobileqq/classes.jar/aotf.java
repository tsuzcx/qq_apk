import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class aotf
  implements View.OnClickListener
{
  public aotf(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    FileManagerEntity localFileManagerEntity;
    int i;
    if ((localObject1 instanceof aoto))
    {
      localObject2 = (aoto)paramView.getTag();
      localObject1 = ((aoto)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
      localFileManagerEntity = (FileManagerEntity)((aoto)localObject2).jdField_a_of_type_JavaLangObject;
      i = ((aoto)localObject2).b;
      i = ((aoto)localObject2).c;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131366211) && (QfileBaseRecentFileTabView.b(this.a))) {
        axqw.b(QfileBaseRecentFileTabView.s(this.a), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
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
        if (!(localObject1 instanceof aopv)) {
          break label188;
        }
        localObject2 = (aopv)paramView.getTag();
        localObject1 = ((aopv)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
        localFileManagerEntity = (FileManagerEntity)((aopv)localObject2).jdField_a_of_type_JavaLangObject;
        i = ((aopv)localObject2).b;
        i = ((aopv)localObject2).jdField_a_of_type_Int;
        break;
      }
      label188:
      localObject1 = null;
      localFileManagerEntity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aotf
 * JD-Core Version:    0.7.0.1
 */