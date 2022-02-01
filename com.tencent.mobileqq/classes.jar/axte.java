import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class axte
{
  private static axte a;
  
  public static axte a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new axte();
      }
      return a;
    }
    finally {}
  }
  
  public static String a(String paramString)
  {
    ariq localariq = (ariq)aran.a().a(490);
    if ((localariq != null) && (localariq.jdField_a_of_type_JavaUtilHashMap != null)) {
      return (String)localariq.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return "";
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt == 0)) {}
    int i;
    do
    {
      do
      {
        return paramString;
        i = paramString.lastIndexOf("/");
        str = paramString.substring(0, i + 1);
      } while (str.length() < 4);
      localObject1 = str.substring(str.length() - 4, str.length() - 3);
      localObject2 = str.substring(str.length() - 3, str.length() - 2);
    } while ((((String)localObject1).equals(String.valueOf(paramInt))) && (((String)localObject2).equals("_")));
    Object localObject1 = new StringBuilder();
    Object localObject2 = ((StringBuilder)localObject1).append(str).append(paramInt).append("_");
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      ((StringBuilder)localObject2).append(str).append(paramString.substring(i));
      str = ((StringBuilder)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.d("appendVasUrl", 2, "originUrl:" + paramString + " appendUrl:" + str);
      }
      return str;
    }
  }
  
  public static void a(Resources paramResources, ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, paramDrawable, null, new axtf(paramResources, paramImageView));
    if (paramString != null)
    {
      int i = agej.a(21.0F, paramResources);
      int j = paramString.getIntrinsicWidth() * i / paramString.getIntrinsicHeight();
      paramResources = paramImageView.getLayoutParams();
      paramResources.height = i;
      paramResources.width = j;
      paramImageView.setImageDrawable(paramString);
      paramImageView.setLayoutParams(paramResources);
      paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, axtj paramaxtj, ariq paramariq)
  {
    int i;
    if ((paramariq != null) && (!TextUtils.isEmpty(paramariq.jdField_b_of_type_JavaLangString)))
    {
      i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 0);
      if ((paramaxtj.h <= 0L) || (paramaxtj.jdField_b_of_type_Long != 2L)) {
        break label145;
      }
      if (!TextUtils.isEmpty(paramaxtj.jdField_b_of_type_JavaLangString)) {
        break label137;
      }
      paramQQAppInterface = paramaxtj.c;
      paramaxtj.jdField_b_of_type_JavaLangString = a(paramQQAppInterface, i, true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RelationVipHelper", 2, "iconApngUrl:" + paramaxtj.jdField_b_of_type_JavaLangString + " sub_level:" + paramaxtj.h + " level:" + paramaxtj.jdField_b_of_type_Long);
      }
      return;
      label137:
      paramQQAppInterface = paramaxtj.jdField_b_of_type_JavaLangString;
      break;
      label145:
      if (paramaxtj.jdField_b_of_type_Long == 1L)
      {
        if (i == 2)
        {
          paramaxtj.jdField_b_of_type_JavaLangString = paramariq.jdField_b_of_type_JavaLangString.replace("{type}", "smallfire");
          paramaxtj.jdField_b_of_type_JavaLangString = paramaxtj.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
        }
        else if (i == 1)
        {
          paramaxtj.jdField_b_of_type_JavaLangString = paramariq.jdField_b_of_type_JavaLangString.replace("{type}", "smallfire");
          paramaxtj.jdField_b_of_type_JavaLangString = paramaxtj.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
        }
      }
      else if (paramaxtj.jdField_b_of_type_Long == 2L) {
        if (i == 2)
        {
          paramaxtj.jdField_b_of_type_JavaLangString = paramariq.jdField_b_of_type_JavaLangString.replace("{type}", "bigfire");
          paramaxtj.jdField_b_of_type_JavaLangString = paramaxtj.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
        }
        else if (i == 1)
        {
          paramaxtj.jdField_b_of_type_JavaLangString = paramariq.jdField_b_of_type_JavaLangString.replace("{type}", "bigfire");
          paramaxtj.jdField_b_of_type_JavaLangString = paramaxtj.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, axtj paramaxtj)
  {
    if ((paramQQAppInterface == null) || (paramaxtj == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      int i;
      do
      {
        ariq localariq;
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
                            localariq = (ariq)aran.a().a(490);
                            switch ((int)paramaxtj.a)
                            {
                            default: 
                              return;
                            }
                          } while ((localariq == null) || (TextUtils.isEmpty(localariq.jdField_b_of_type_JavaLangString)));
                          i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 2);
                          if ((paramaxtj.jdField_b_of_type_Long != 0L) || (i <= 0)) {
                            break;
                          }
                          paramaxtj.jdField_b_of_type_JavaLangString = localariq.jdField_b_of_type_JavaLangString.replace("{type}", "lover1");
                          paramaxtj.jdField_b_of_type_JavaLangString = paramaxtj.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                          return;
                          a(paramQQAppInterface, paramString, paramaxtj, localariq);
                          return;
                        } while ((localariq == null) || (TextUtils.isEmpty(localariq.jdField_b_of_type_JavaLangString)));
                        i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 1);
                        if (paramaxtj.jdField_b_of_type_Long != 1L) {
                          break;
                        }
                        if (i == 2)
                        {
                          paramaxtj.jdField_b_of_type_JavaLangString = localariq.jdField_b_of_type_JavaLangString.replace("{type}", "smallship");
                          paramaxtj.jdField_b_of_type_JavaLangString = paramaxtj.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                          return;
                        }
                      } while (i != 1);
                      paramaxtj.jdField_b_of_type_JavaLangString = localariq.jdField_b_of_type_JavaLangString.replace("{type}", "smallship");
                      paramaxtj.jdField_b_of_type_JavaLangString = paramaxtj.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                      return;
                    } while (paramaxtj.jdField_b_of_type_Long != 2L);
                    if (i == 2)
                    {
                      paramaxtj.jdField_b_of_type_JavaLangString = localariq.jdField_b_of_type_JavaLangString.replace("{type}", "bigship");
                      paramaxtj.jdField_b_of_type_JavaLangString = paramaxtj.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                      return;
                    }
                  } while (i != 1);
                  paramaxtj.jdField_b_of_type_JavaLangString = localariq.jdField_b_of_type_JavaLangString.replace("{type}", "bigship");
                  paramaxtj.jdField_b_of_type_JavaLangString = paramaxtj.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                  return;
                  if ((paramaxtj.jdField_b_of_type_Long == 1L) && (i > 0))
                  {
                    paramaxtj.jdField_b_of_type_JavaLangString = localariq.jdField_b_of_type_JavaLangString.replace("{type}", "lover2");
                    paramaxtj.jdField_b_of_type_JavaLangString = paramaxtj.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                    return;
                  }
                } while ((paramaxtj.jdField_b_of_type_Long != 2L) || (i <= 0));
                paramaxtj.jdField_b_of_type_JavaLangString = localariq.jdField_b_of_type_JavaLangString.replace("{type}", "lover3");
                paramaxtj.jdField_b_of_type_JavaLangString = paramaxtj.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                return;
              } while ((localariq == null) || (TextUtils.isEmpty(localariq.jdField_b_of_type_JavaLangString)));
              i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 3);
              if ((paramaxtj.jdField_b_of_type_Long == 0L) && (i > 0))
              {
                paramaxtj.jdField_b_of_type_JavaLangString = localariq.jdField_b_of_type_JavaLangString.replace("{type}", "sister1");
                paramString = paramaxtj.jdField_b_of_type_JavaLangString;
                if (i == 1) {}
                for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
                {
                  paramaxtj.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
                  return;
                }
              }
              if ((paramaxtj.jdField_b_of_type_Long == 1L) && (i > 0))
              {
                paramaxtj.jdField_b_of_type_JavaLangString = localariq.jdField_b_of_type_JavaLangString.replace("{type}", "sister2");
                paramString = paramaxtj.jdField_b_of_type_JavaLangString;
                if (i == 1) {}
                for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
                {
                  paramaxtj.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
                  return;
                }
              }
            } while ((paramaxtj.jdField_b_of_type_Long != 2L) || (i <= 0));
            paramaxtj.jdField_b_of_type_JavaLangString = localariq.jdField_b_of_type_JavaLangString.replace("{type}", "sister3");
            paramString = paramaxtj.jdField_b_of_type_JavaLangString;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramaxtj.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          } while ((localariq == null) || (TextUtils.isEmpty(localariq.jdField_b_of_type_JavaLangString)));
          i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 4);
          if ((paramaxtj.jdField_b_of_type_Long == 0L) && (i > 0))
          {
            paramaxtj.jdField_b_of_type_JavaLangString = localariq.jdField_b_of_type_JavaLangString.replace("{type}", "brother1");
            paramString = paramaxtj.jdField_b_of_type_JavaLangString;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramaxtj.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          }
          if ((paramaxtj.jdField_b_of_type_Long == 1L) && (i > 0))
          {
            paramaxtj.jdField_b_of_type_JavaLangString = localariq.jdField_b_of_type_JavaLangString.replace("{type}", "brother2");
            paramString = paramaxtj.jdField_b_of_type_JavaLangString;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramaxtj.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          }
        } while ((paramaxtj.jdField_b_of_type_Long != 2L) || (i <= 0));
        paramaxtj.jdField_b_of_type_JavaLangString = localariq.jdField_b_of_type_JavaLangString.replace("{type}", "brother3");
        paramString = paramaxtj.jdField_b_of_type_JavaLangString;
        if (i == 1) {}
        for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
        {
          paramaxtj.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
          return;
        }
        i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 5);
        if ((i == 1) && (paramaxtj.jdField_b_of_type_Long == 1L))
        {
          paramaxtj.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_svip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_NTF6EEcVWV.png");
          return;
        }
        if ((i == 2) && (paramaxtj.jdField_b_of_type_Long == 1L))
        {
          paramaxtj.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191111173708_UYRdOtYOfJ.png");
          return;
        }
        if ((i == 3) && (paramaxtj.jdField_b_of_type_Long == 1L))
        {
          paramaxtj.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_yellowvip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127145904_DNAFqFLjOz.png");
          return;
        }
      } while ((i != 4) || (paramaxtj.jdField_b_of_type_Long != 1L));
      paramaxtj.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_newyear_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_evBQGhifVq.png");
      return;
      if (paramaxtj.jdField_b_of_type_Long == 1L)
      {
        paramaxtj.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/24f5b4859404c4de52aa329d4d05ee5d.png";
        return;
      }
      if (paramaxtj.jdField_b_of_type_Long == 2L)
      {
        paramaxtj.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/16baf9bdf1b7a672001939b447e5f3c9.png";
        return;
      }
    } while (paramaxtj.jdField_b_of_type_Long != 3L);
    paramaxtj.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/c4e28479a1f47ff9e3104cf3e96c2430.png";
  }
  
  public boolean a()
  {
    ariq localariq = (ariq)aran.a().a(490);
    return (localariq != null) && (localariq.jdField_a_of_type_Int != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axte
 * JD-Core Version:    0.7.0.1
 */