import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class asbt
{
  private static asbt a;
  
  public static asbt a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new asbt();
      }
      return a;
    }
    finally {}
  }
  
  public static String a(String paramString)
  {
    amfn localamfn = (amfn)alzw.a().a(490);
    if ((localamfn != null) && (localamfn.jdField_a_of_type_JavaUtilHashMap != null)) {
      return (String)localamfn.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return "";
  }
  
  public static void a(Resources paramResources, ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    paramString = baop.a(paramString, baop.b, paramDrawable, null, new asbu(paramResources, paramImageView));
    if (paramString != null)
    {
      int i = aciy.a(21.0F, paramResources);
      int j = paramString.getIntrinsicWidth() * i / paramString.getIntrinsicHeight();
      paramResources = paramImageView.getLayoutParams();
      paramResources.height = i;
      paramResources.width = j;
      paramImageView.setImageDrawable(paramString);
      paramImageView.setLayoutParams(paramResources);
      paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, asbx paramasbx)
  {
    if ((paramQQAppInterface == null) || (paramasbx == null) || (TextUtils.isEmpty(paramString))) {}
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
                                    paramQQAppInterface = (amfn)alzw.a().a(490);
                                    switch ((int)paramasbx.a)
                                    {
                                    default: 
                                      return;
                                    }
                                  } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.jdField_b_of_type_JavaLangString)));
                                  i = bajr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 2);
                                  if ((paramasbx.jdField_b_of_type_Long != 0L) || (i <= 0)) {
                                    break;
                                  }
                                  paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "lover1");
                                  paramasbx.jdField_b_of_type_JavaLangString = paramasbx.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                                  return;
                                } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.jdField_b_of_type_JavaLangString)));
                                i = bajr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 0);
                                if (paramasbx.jdField_b_of_type_Long != 1L) {
                                  break;
                                }
                                if (i == 2)
                                {
                                  paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "smallfire");
                                  paramasbx.jdField_b_of_type_JavaLangString = paramasbx.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                                  return;
                                }
                              } while (i != 1);
                              paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "smallfire");
                              paramasbx.jdField_b_of_type_JavaLangString = paramasbx.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                              return;
                            } while (paramasbx.jdField_b_of_type_Long != 2L);
                            if (i == 2)
                            {
                              paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "bigfire");
                              paramasbx.jdField_b_of_type_JavaLangString = paramasbx.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                              return;
                            }
                          } while (i != 1);
                          paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "bigfire");
                          paramasbx.jdField_b_of_type_JavaLangString = paramasbx.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                          return;
                        } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.jdField_b_of_type_JavaLangString)));
                        i = bajr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 1);
                        if (paramasbx.jdField_b_of_type_Long != 1L) {
                          break;
                        }
                        if (i == 2)
                        {
                          paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "smallship");
                          paramasbx.jdField_b_of_type_JavaLangString = paramasbx.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                          return;
                        }
                      } while (i != 1);
                      paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "smallship");
                      paramasbx.jdField_b_of_type_JavaLangString = paramasbx.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                      return;
                    } while (paramasbx.jdField_b_of_type_Long != 2L);
                    if (i == 2)
                    {
                      paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "bigship");
                      paramasbx.jdField_b_of_type_JavaLangString = paramasbx.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                      return;
                    }
                  } while (i != 1);
                  paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "bigship");
                  paramasbx.jdField_b_of_type_JavaLangString = paramasbx.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                  return;
                  if ((paramasbx.jdField_b_of_type_Long == 1L) && (i > 0))
                  {
                    paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "lover2");
                    paramasbx.jdField_b_of_type_JavaLangString = paramasbx.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                    return;
                  }
                } while ((paramasbx.jdField_b_of_type_Long != 2L) || (i <= 0));
                paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "lover3");
                paramasbx.jdField_b_of_type_JavaLangString = paramasbx.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                return;
              } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.jdField_b_of_type_JavaLangString)));
              i = bajr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 3);
              if ((paramasbx.jdField_b_of_type_Long == 0L) && (i > 0))
              {
                paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "sister1");
                paramString = paramasbx.jdField_b_of_type_JavaLangString;
                if (i == 1) {}
                for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
                {
                  paramasbx.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
                  return;
                }
              }
              if ((paramasbx.jdField_b_of_type_Long == 1L) && (i > 0))
              {
                paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "sister2");
                paramString = paramasbx.jdField_b_of_type_JavaLangString;
                if (i == 1) {}
                for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
                {
                  paramasbx.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
                  return;
                }
              }
            } while ((paramasbx.jdField_b_of_type_Long != 2L) || (i <= 0));
            paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "sister3");
            paramString = paramasbx.jdField_b_of_type_JavaLangString;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramasbx.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.jdField_b_of_type_JavaLangString)));
          i = bajr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 4);
          if ((paramasbx.jdField_b_of_type_Long == 0L) && (i > 0))
          {
            paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "brother1");
            paramString = paramasbx.jdField_b_of_type_JavaLangString;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramasbx.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          }
          if ((paramasbx.jdField_b_of_type_Long == 1L) && (i > 0))
          {
            paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "brother2");
            paramString = paramasbx.jdField_b_of_type_JavaLangString;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramasbx.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          }
        } while ((paramasbx.jdField_b_of_type_Long != 2L) || (i <= 0));
        paramasbx.jdField_b_of_type_JavaLangString = paramQQAppInterface.jdField_b_of_type_JavaLangString.replace("{type}", "brother3");
        paramString = paramasbx.jdField_b_of_type_JavaLangString;
        if (i == 1) {}
        for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
        {
          paramasbx.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
          return;
        }
        i = bajr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 5);
        if ((i == 1) && (paramasbx.jdField_b_of_type_Long == 1L))
        {
          paramasbx.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_svip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_NTF6EEcVWV.png");
          return;
        }
        if ((i == 2) && (paramasbx.jdField_b_of_type_Long == 1L))
        {
          paramasbx.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191111173708_UYRdOtYOfJ.png");
          return;
        }
        if ((i == 3) && (paramasbx.jdField_b_of_type_Long == 1L))
        {
          paramasbx.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_yellowvip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127145904_DNAFqFLjOz.png");
          return;
        }
      } while ((i != 4) || (paramasbx.jdField_b_of_type_Long != 1L));
      paramasbx.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_newyear_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_evBQGhifVq.png");
      return;
      if (paramasbx.jdField_b_of_type_Long == 1L)
      {
        paramasbx.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/24f5b4859404c4de52aa329d4d05ee5d.png";
        return;
      }
      if (paramasbx.jdField_b_of_type_Long == 2L)
      {
        paramasbx.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/16baf9bdf1b7a672001939b447e5f3c9.png";
        return;
      }
    } while (paramasbx.jdField_b_of_type_Long != 3L);
    paramasbx.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/c4e28479a1f47ff9e3104cf3e96c2430.png";
  }
  
  public boolean a()
  {
    amfn localamfn = (amfn)alzw.a().a(490);
    return (localamfn != null) && (localamfn.jdField_a_of_type_Int != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asbt
 * JD-Core Version:    0.7.0.1
 */