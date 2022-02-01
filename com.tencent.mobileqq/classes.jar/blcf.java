import android.graphics.drawable.Drawable;
import cooperation.vip.vipcomponent.ui.QzoneHuangzuanVipIconShow;
import cooperation.vip.vipcomponent.util.VipResourcesListener;

public class blcf
  extends blcn
{
  public blcf(QzoneHuangzuanVipIconShow paramQzoneHuangzuanVipIconShow, VipResourcesListener paramVipResourcesListener, int paramInt1, blcc paramblcc, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString, int paramInt4, boolean paramBoolean2, int paramInt5) {}
  
  public void onDownloaded(String paramString1, int paramInt, String paramString2, Drawable paramDrawable)
  {
    QzoneHuangzuanVipIconShow.access$000(this.jdField_a_of_type_CooperationVipVipcomponentUiQzoneHuangzuanVipIconShow, paramInt, paramDrawable, this.jdField_a_of_type_Int, this.jdField_a_of_type_Blcc, this.jdField_b_of_type_Int);
    if (this.mCount <= 0)
    {
      QzoneHuangzuanVipIconShow.access$100(this.jdField_a_of_type_CooperationVipVipcomponentUiQzoneHuangzuanVipIconShow, this.jdField_a_of_type_Blcc, this.c, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_b_of_type_Boolean, this.e);
      if (this.jdField_a_of_type_CooperationVipVipcomponentUtilVipResourcesListener != null) {
        this.jdField_a_of_type_CooperationVipVipcomponentUtilVipResourcesListener.onLoaded(this.jdField_a_of_type_Blcc);
      }
    }
  }
  
  public void onFailed(String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_CooperationVipVipcomponentUtilVipResourcesListener != null) {
      this.jdField_a_of_type_CooperationVipVipcomponentUtilVipResourcesListener.onFailed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcf
 * JD-Core Version:    0.7.0.1
 */