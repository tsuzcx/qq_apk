import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import cooperation.vip.vipcomponent.ui.QzoneHuangzuanVipIconShow;
import cooperation.vip.vipcomponent.util.VipResourcesListener;

public class bkgx
  extends bkhf
{
  public bkgx(QzoneHuangzuanVipIconShow paramQzoneHuangzuanVipIconShow, VipResourcesListener paramVipResourcesListener, int paramInt1, bkgu parambkgu, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString, int paramInt4, boolean paramBoolean2, int paramInt5) {}
  
  public void onDownloaded(String paramString1, int paramInt, String paramString2, Drawable paramDrawable)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.mCount <= 0)
      {
        QzoneHuangzuanVipIconShow.access$100(this.jdField_a_of_type_CooperationVipVipcomponentUiQzoneHuangzuanVipIconShow, this.jdField_a_of_type_Bkgu, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.c, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_b_of_type_Boolean, this.e);
        if (this.jdField_a_of_type_CooperationVipVipcomponentUtilVipResourcesListener != null) {
          this.jdField_a_of_type_CooperationVipVipcomponentUtilVipResourcesListener.onLoaded(this.jdField_a_of_type_Bkgu);
        }
      }
      return;
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE, this.jdField_a_of_type_Int));
        this.jdField_a_of_type_Bkgu.a(paramDrawable);
        continue;
        if (paramDrawable != null)
        {
          paramDrawable.setBounds(QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicWidth(), this.jdField_a_of_type_Int) / 2, QzoneHuangzuanVipIconShow.access$000(-QzoneHuangzuanVipIconShow.PERSONALIZED_ICON_AVATAR_TOP, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE + paramDrawable.getIntrinsicWidth(), this.jdField_a_of_type_Int) / 2, QzoneHuangzuanVipIconShow.access$000(paramDrawable.getIntrinsicHeight() - QzoneHuangzuanVipIconShow.PERSONALIZED_ICON_AVATAR_TOP, this.jdField_a_of_type_Int));
          this.jdField_a_of_type_Bkgu.d(paramDrawable);
          continue;
          if (paramDrawable != null)
          {
            paramDrawable.setBounds(0, 0, QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE, this.jdField_a_of_type_Int));
            this.jdField_a_of_type_Bkgu.b(paramDrawable);
            continue;
            if (paramDrawable != null)
            {
              paramDrawable.setBounds(0, QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.RIBBON_ICON_LEVEL_MARGIN_TOP, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE + QzoneHuangzuanVipIconShow.RIBBON_ICON_LEVEL_MARGIN_TOP, this.jdField_a_of_type_Int));
              this.jdField_a_of_type_Bkgu.b(paramDrawable);
              continue;
              if (paramDrawable != null)
              {
                paramDrawable.setBounds(QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE / 2, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_ADJUST_ANNUALVIP_MARGIN_TOP, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_ANNUALVIP_WIDTH + QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE / 2 + QzoneHuangzuanVipIconShow.ANUAL_ICON_MARGIN_LEFT, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_ADJUST_ANNUALVIP_MARGIN_TOP + QzoneHuangzuanVipIconShow.ICON_ANNUALVIP_HEIGHT, this.jdField_a_of_type_Int));
                this.jdField_a_of_type_Bkgu.c(paramDrawable);
                continue;
                if (paramDrawable != null)
                {
                  paramDrawable.setBounds(QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE - QzoneHuangzuanVipIconShow.PERSONALIZED_ICON_ANUAL_LEFT, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicHeight(), this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE - QzoneHuangzuanVipIconShow.PERSONALIZED_ICON_ANUAL_LEFT + paramDrawable.getIntrinsicWidth(), this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE, this.jdField_a_of_type_Int));
                  this.jdField_a_of_type_Bkgu.c(paramDrawable);
                  bkha.b("@vipIcon", "left" + QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE / 2 + " width = " + paramDrawable.getIntrinsicWidth() + " defualt_width =" + QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE + " height = " + paramDrawable.getIntrinsicHeight());
                  continue;
                  if (paramDrawable != null)
                  {
                    paramDrawable.setBounds(0, QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.PERSONALIZED_ICON_LV_MARGIN_TOP, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.PERSONALIZED_ICON_LV_WIDTH, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.PERSONALIZED_ICON_LV_HEIGHT + QzoneHuangzuanVipIconShow.PERSONALIZED_ICON_LV_MARGIN_TOP, this.jdField_a_of_type_Int));
                    this.jdField_a_of_type_Bkgu.b(paramDrawable);
                    continue;
                    if (paramDrawable != null)
                    {
                      paramDrawable.setBounds(QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.LV9_GUAN_ICON_MARGIN_LEFT, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.LV9_GUAN_ICON_MARGIN_TOP, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.LV9_GUAN_ICON_WIDTH + QzoneHuangzuanVipIconShow.LV9_GUAN_ICON_MARGIN_LEFT, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.LV9_GUAN_ICON_HEIGHT + QzoneHuangzuanVipIconShow.LV9_GUAN_ICON_MARGIN_TOP, this.jdField_a_of_type_Int));
                      this.jdField_a_of_type_Bkgu.d(paramDrawable);
                      continue;
                      if (paramDrawable != null)
                      {
                        paramDrawable.setBounds(QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.LV9_WINDS_MARGIN_LEFT, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.LV9_WINDS_MARGIN_TOP, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.LV9_WINDS_WIDTH + QzoneHuangzuanVipIconShow.LV9_WINDS_MARGIN_LEFT, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.LV9_WINDS_HEIGHT + QzoneHuangzuanVipIconShow.LV9_WINDS_MARGIN_TOP, this.jdField_a_of_type_Int));
                        this.jdField_a_of_type_Bkgu.e(paramDrawable);
                        continue;
                        if (paramDrawable != null)
                        {
                          paramDrawable.setBounds(QzoneHuangzuanVipIconShow.access$000((QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicWidth()) / 2, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicHeight(), this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000((QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE + paramDrawable.getIntrinsicWidth()) / 2, this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE, this.jdField_a_of_type_Int));
                          this.jdField_a_of_type_Bkgu.f(paramDrawable);
                          bkha.b("@vipIcon KINGBG", "left=" + (QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicWidth()) / 2 + " width = " + paramDrawable.getIntrinsicWidth() + " defualt_width =" + QzoneHuangzuanVipIconShow.ICON_DEFAULT_SIZE + " height = " + paramDrawable.getIntrinsicHeight() + " bitmapwith =" + (int)(((BitmapDrawable)paramDrawable).getBitmap().getWidth() / 2 * bdoo.a()) + "bitmapheight =" + (int)(((BitmapDrawable)paramDrawable).getBitmap().getHeight() / 2 * bdoo.a()));
                          continue;
                          if (paramDrawable != null)
                          {
                            paramDrawable.setBounds(0, 0, QzoneHuangzuanVipIconShow.access$000(paramDrawable.getIntrinsicWidth(), this.jdField_a_of_type_Int), QzoneHuangzuanVipIconShow.access$000(paramDrawable.getIntrinsicHeight(), this.jdField_a_of_type_Int));
                            this.jdField_a_of_type_Bkgu.g(paramDrawable);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
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
 * Qualified Name:     bkgx
 * JD-Core Version:    0.7.0.1
 */