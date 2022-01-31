import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class asxx
{
  private static asxx a;
  
  public static asxx a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new asxx();
      }
      return a;
    }
    finally {}
  }
  
  public static String a(String paramString)
  {
    amvt localamvt = (amvt)ampm.a().a(490);
    if ((localamvt != null) && (localamvt.jdField_a_of_type_JavaUtilHashMap != null)) {
      return (String)localamvt.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return "";
  }
  
  public static void a(Resources paramResources, ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    paramString = bbql.a(paramString, bbql.b, paramDrawable, null, new asxy(paramResources, paramImageView));
    if (paramString != null)
    {
      int i = actn.a(21.0F, paramResources);
      int j = paramString.getIntrinsicWidth() * i / paramString.getIntrinsicHeight();
      paramResources = paramImageView.getLayoutParams();
      paramResources.height = i;
      paramResources.width = j;
      paramImageView.setImageDrawable(paramString);
      paramImageView.setLayoutParams(paramResources);
      paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, asyb paramasyb)
  {
    if ((paramQQAppInterface == null) || (paramasyb == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return;
                                    paramQQAppInterface = (amvt)ampm.a().a(490);
                                    switch ((int)paramasyb.a)
                                    {
                                    default: 
                                      return;
                                    }
                                  } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.jdField_b_of_type_JavaLangString)));
                                  i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 2);
                                  if ((paramasyb.jdField_b_of_type_Long != 0L) || (i <= 0)) {
                                    break;
                                  }
                                  paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "lover1");
                                  paramasyb.jdField_b_of_type_JavaLangString = paramasyb.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                                  return;
                                } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.jdField_b_of_type_JavaLangString)));
                                i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 0);
                                if (paramasyb.jdField_b_of_type_Long != 1L) {
                                  break;
                                }
                                if (i == 2)
                                {
                                  paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "smallfire");
                                  paramasyb.jdField_b_of_type_JavaLangString = paramasyb.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                                  return;
                                }
                              } while (i != 1);
                              paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "smallfire");
                              paramasyb.jdField_b_of_type_JavaLangString = paramasyb.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                              return;
                            } while (paramasyb.jdField_b_of_type_Long != 2L);
                            if (i == 2)
                            {
                              paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "bigfire");
                              paramasyb.jdField_b_of_type_JavaLangString = paramasyb.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                              return;
                            }
                          } while (i != 1);
                          paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "bigfire");
                          paramasyb.jdField_b_of_type_JavaLangString = paramasyb.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                          return;
                        } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.jdField_b_of_type_JavaLangString)));
                        i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 1);
                        if (paramasyb.jdField_b_of_type_Long != 1L) {
                          break;
                        }
                        if (i == 2)
                        {
                          paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "smallship");
                          paramasyb.jdField_b_of_type_JavaLangString = paramasyb.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                          return;
                        }
                      } while (i != 1);
                      paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "smallship");
                      paramasyb.jdField_b_of_type_JavaLangString = paramasyb.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                      return;
                    } while (paramasyb.jdField_b_of_type_Long != 2L);
                    if (i == 2)
                    {
                      paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "bigship");
                      paramasyb.jdField_b_of_type_JavaLangString = paramasyb.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                      return;
                    }
                  } while (i != 1);
                  paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "bigship");
                  paramasyb.jdField_b_of_type_JavaLangString = paramasyb.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                  return;
                  if ((paramasyb.jdField_b_of_type_Long == 1L) && (i > 0))
                  {
                    paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "lover2");
                    paramasyb.jdField_b_of_type_JavaLangString = paramasyb.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                    return;
                  }
                } while ((paramasyb.jdField_b_of_type_Long != 2L) || (i <= 0));
                paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "lover3");
                paramasyb.jdField_b_of_type_JavaLangString = paramasyb.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                return;
              } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.jdField_b_of_type_JavaLangString)));
              i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 3);
              if ((paramasyb.jdField_b_of_type_Long == 0L) && (i > 0))
              {
                paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "sister1");
                paramString = paramasyb.jdField_b_of_type_JavaLangString;
                if (i == 1) {}
                for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
                {
                  paramasyb.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
                  return;
                }
              }
              if ((paramasyb.jdField_b_of_type_Long == 1L) && (i > 0))
              {
                paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "sister2");
                paramString = paramasyb.jdField_b_of_type_JavaLangString;
                if (i == 1) {}
                for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
                {
                  paramasyb.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
                  return;
                }
              }
            } while ((paramasyb.jdField_b_of_type_Long != 2L) || (i <= 0));
            paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "sister3");
            paramString = paramasyb.jdField_b_of_type_JavaLangString;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramasyb.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.jdField_b_of_type_JavaLangString)));
          i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 4);
          if ((paramasyb.jdField_b_of_type_Long == 0L) && (i > 0))
          {
            paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "brother1");
            paramString = paramasyb.jdField_b_of_type_JavaLangString;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramasyb.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          }
          if ((paramasyb.jdField_b_of_type_Long == 1L) && (i > 0))
          {
            paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "brother2");
            paramString = paramasyb.jdField_b_of_type_JavaLangString;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramasyb.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          }
        } while ((paramasyb.jdField_b_of_type_Long != 2L) || (i <= 0));
        paramasyb.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "brother3");
        paramString = paramasyb.jdField_b_of_type_JavaLangString;
        if (i == 1) {}
        for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
        {
          paramasyb.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
          return;
        }
        i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 5);
        if ((i == 1) && (paramasyb.jdField_b_of_type_Long == 1L))
        {
          paramasyb.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_svip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_NTF6EEcVWV.png");
          return;
        }
        if ((i == 2) && (paramasyb.jdField_b_of_type_Long == 1L))
        {
          paramasyb.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191111173708_UYRdOtYOfJ.png");
          return;
        }
        if ((i == 3) && (paramasyb.jdField_b_of_type_Long == 1L))
        {
          paramasyb.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_yellowvip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127145904_DNAFqFLjOz.png");
          return;
        }
      } while ((i != 4) || (paramasyb.jdField_b_of_type_Long != 1L));
      paramasyb.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_newyear_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_evBQGhifVq.png");
      return;
      if (paramasyb.jdField_b_of_type_Long == 1L)
      {
        paramasyb.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/24f5b4859404c4de52aa329d4d05ee5d.png";
        return;
      }
      if (paramasyb.jdField_b_of_type_Long == 2L)
      {
        paramasyb.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/16baf9bdf1b7a672001939b447e5f3c9.png";
        return;
      }
    } while (paramasyb.jdField_b_of_type_Long != 3L);
    paramasyb.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/c4e28479a1f47ff9e3104cf3e96c2430.png";
  }
  
  public boolean a()
  {
    amvt localamvt = (amvt)ampm.a().a(490);
    return (localamvt != null) && (localamvt.jdField_a_of_type_Int != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxx
 * JD-Core Version:    0.7.0.1
 */