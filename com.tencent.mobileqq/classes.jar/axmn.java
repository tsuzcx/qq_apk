import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class axmn
{
  private static axmn a;
  
  public static axmn a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new axmn();
      }
      return a;
    }
    finally {}
  }
  
  public static String a(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    String str = arcc.a().h + "/vas/";
    if ((TextUtils.isEmpty(str)) || (paramInt == 0)) {
      return str;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(str).append(paramInt).append("_").append(paramLong1).append("_").append(paramLong2).append("_");
    if (paramBoolean) {}
    for (str = "1";; str = "0") {
      return str + ".png";
    }
  }
  
  public static String a(String paramString)
  {
    arfo localarfo = (arfo)aqxe.a().a(490);
    if ((localarfo != null) && (localarfo.jdField_a_of_type_JavaUtilHashMap != null)) {
      return (String)localarfo.jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, paramDrawable, null, new axmo(paramResources, paramImageView));
    if (paramString != null)
    {
      int i = AIOUtils.dp2px(21.0F, paramResources);
      int j = paramString.getIntrinsicWidth() * i / paramString.getIntrinsicHeight();
      paramResources = paramImageView.getLayoutParams();
      paramResources.height = i;
      paramResources.width = j;
      paramImageView.setImageDrawable(paramString);
      paramImageView.setLayoutParams(paramResources);
      paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, axms paramaxms, arfo paramarfo)
  {
    int i;
    if ((paramarfo != null) && (!TextUtils.isEmpty(paramarfo.jdField_b_of_type_JavaLangString)))
    {
      i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 0);
      if ((paramaxms.h <= 0L) || (paramaxms.jdField_b_of_type_Long != 6L)) {
        break label145;
      }
      if (!TextUtils.isEmpty(paramaxms.jdField_b_of_type_JavaLangString)) {
        break label137;
      }
      paramQQAppInterface = paramaxms.c;
    }
    for (paramaxms.jdField_b_of_type_JavaLangString = a(paramQQAppInterface, i, true);; paramaxms.jdField_b_of_type_JavaLangString = a(5L, i, paramaxms.jdField_b_of_type_Long, true)) {
      label137:
      label145:
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("RelationVipHelper", 2, "iconApngUrl:" + paramaxms.jdField_b_of_type_JavaLangString + " sub_level:" + paramaxms.h + " level:" + paramaxms.jdField_b_of_type_Long);
        }
        return;
        paramQQAppInterface = paramaxms.jdField_b_of_type_JavaLangString;
        break;
      } while ((i <= 0) || (paramaxms.jdField_b_of_type_Long <= 0L));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, axms paramaxms)
  {
    if ((paramQQAppInterface == null) || (paramaxms == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      int i;
      do
      {
        arfo localarfo;
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
                              localarfo = (arfo)aqxe.a().a(490);
                              switch ((int)paramaxms.a)
                              {
                              default: 
                                return;
                              }
                            } while ((localarfo == null) || (TextUtils.isEmpty(localarfo.jdField_b_of_type_JavaLangString)));
                            i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 2);
                            if ((paramaxms.jdField_b_of_type_Long != 0L) || (i <= 0)) {
                              break;
                            }
                            paramaxms.jdField_b_of_type_JavaLangString = localarfo.jdField_b_of_type_JavaLangString.replace("{type}", "lover1");
                            paramaxms.jdField_b_of_type_JavaLangString = paramaxms.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                            return;
                            a(paramQQAppInterface, paramString, paramaxms, localarfo);
                            return;
                          } while ((localarfo == null) || (TextUtils.isEmpty(localarfo.jdField_b_of_type_JavaLangString)));
                          i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 1);
                          if (paramaxms.jdField_b_of_type_Long != 1L) {
                            break;
                          }
                          if (i == 2)
                          {
                            paramaxms.jdField_b_of_type_JavaLangString = localarfo.jdField_b_of_type_JavaLangString.replace("{type}", "smallship");
                            paramaxms.jdField_b_of_type_JavaLangString = paramaxms.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                            return;
                          }
                        } while (i != 1);
                        paramaxms.jdField_b_of_type_JavaLangString = localarfo.jdField_b_of_type_JavaLangString.replace("{type}", "smallship");
                        paramaxms.jdField_b_of_type_JavaLangString = paramaxms.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                        return;
                      } while (paramaxms.jdField_b_of_type_Long != 2L);
                      if (i == 2)
                      {
                        paramaxms.jdField_b_of_type_JavaLangString = localarfo.jdField_b_of_type_JavaLangString.replace("{type}", "bigship");
                        paramaxms.jdField_b_of_type_JavaLangString = paramaxms.jdField_b_of_type_JavaLangString.replace("{vip}", "union_vip");
                        return;
                      }
                    } while (i != 1);
                    paramaxms.jdField_b_of_type_JavaLangString = localarfo.jdField_b_of_type_JavaLangString.replace("{type}", "bigship");
                    paramaxms.jdField_b_of_type_JavaLangString = paramaxms.jdField_b_of_type_JavaLangString.replace("{vip}", "svip");
                    return;
                    if ((paramaxms.jdField_b_of_type_Long == 1L) && (i > 0))
                    {
                      paramaxms.jdField_b_of_type_JavaLangString = localarfo.jdField_b_of_type_JavaLangString.replace("{type}", "lover2");
                      paramaxms.jdField_b_of_type_JavaLangString = paramaxms.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                      return;
                    }
                  } while ((paramaxms.jdField_b_of_type_Long != 2L) || (i <= 0));
                  paramaxms.jdField_b_of_type_JavaLangString = localarfo.jdField_b_of_type_JavaLangString.replace("{type}", "lover3");
                  paramaxms.jdField_b_of_type_JavaLangString = paramaxms.jdField_b_of_type_JavaLangString.replace("{vip}", "vip");
                  return;
                } while ((localarfo == null) || (TextUtils.isEmpty(localarfo.jdField_b_of_type_JavaLangString)));
                i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 3);
                if ((paramaxms.jdField_b_of_type_Long == 0L) && (i > 0))
                {
                  paramaxms.jdField_b_of_type_JavaLangString = localarfo.jdField_b_of_type_JavaLangString.replace("{type}", "sister1");
                  paramString = paramaxms.jdField_b_of_type_JavaLangString;
                  if (i == 1) {}
                  for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
                  {
                    paramaxms.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
                    return;
                  }
                }
                if ((paramaxms.jdField_b_of_type_Long == 1L) && (i > 0))
                {
                  paramaxms.jdField_b_of_type_JavaLangString = localarfo.jdField_b_of_type_JavaLangString.replace("{type}", "sister2");
                  paramString = paramaxms.jdField_b_of_type_JavaLangString;
                  if (i == 1) {}
                  for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
                  {
                    paramaxms.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
                    return;
                  }
                }
              } while ((paramaxms.jdField_b_of_type_Long != 2L) || (i <= 0));
              paramaxms.jdField_b_of_type_JavaLangString = localarfo.jdField_b_of_type_JavaLangString.replace("{type}", "sister3");
              paramString = paramaxms.jdField_b_of_type_JavaLangString;
              if (i == 1) {}
              for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
              {
                paramaxms.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
                return;
              }
            } while ((localarfo == null) || (TextUtils.isEmpty(localarfo.jdField_b_of_type_JavaLangString)));
            return;
          } while ((localarfo == null) || (TextUtils.isEmpty(localarfo.jdField_b_of_type_JavaLangString)));
          i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 4);
          if ((paramaxms.jdField_b_of_type_Long == 0L) && (i > 0))
          {
            paramaxms.jdField_b_of_type_JavaLangString = localarfo.jdField_b_of_type_JavaLangString.replace("{type}", "brother1");
            paramString = paramaxms.jdField_b_of_type_JavaLangString;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramaxms.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          }
          if ((paramaxms.jdField_b_of_type_Long == 1L) && (i > 0))
          {
            paramaxms.jdField_b_of_type_JavaLangString = localarfo.jdField_b_of_type_JavaLangString.replace("{type}", "brother2");
            paramString = paramaxms.jdField_b_of_type_JavaLangString;
            if (i == 1) {}
            for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
            {
              paramaxms.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
              return;
            }
          }
        } while ((paramaxms.jdField_b_of_type_Long != 2L) || (i <= 0));
        paramaxms.jdField_b_of_type_JavaLangString = localarfo.jdField_b_of_type_JavaLangString.replace("{type}", "brother3");
        paramString = paramaxms.jdField_b_of_type_JavaLangString;
        if (i == 1) {}
        for (paramQQAppInterface = "svip";; paramQQAppInterface = "union_vip")
        {
          paramaxms.jdField_b_of_type_JavaLangString = paramString.replace("{vip}", paramQQAppInterface);
          return;
        }
        i = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 5);
        if ((i == 1) && (paramaxms.jdField_b_of_type_Long == 1L))
        {
          paramaxms.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_svip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_NTF6EEcVWV.png");
          return;
        }
        if ((i == 2) && (paramaxms.jdField_b_of_type_Long == 1L))
        {
          paramaxms.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191111173708_UYRdOtYOfJ.png");
          return;
        }
        if ((i == 3) && (paramaxms.jdField_b_of_type_Long == 1L))
        {
          paramaxms.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_yellowvip_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127145904_DNAFqFLjOz.png");
          return;
        }
      } while ((i != 4) || (paramaxms.jdField_b_of_type_Long != 1L));
      paramaxms.jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("H5Url", "mentorship_newyear_apng_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191127150330_evBQGhifVq.png");
      return;
      if (paramaxms.jdField_b_of_type_Long == 1L)
      {
        paramaxms.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/24f5b4859404c4de52aa329d4d05ee5d.png";
        return;
      }
      if (paramaxms.jdField_b_of_type_Long == 2L)
      {
        paramaxms.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/16baf9bdf1b7a672001939b447e5f3c9.png";
        return;
      }
    } while (paramaxms.jdField_b_of_type_Long != 3L);
    paramaxms.jdField_b_of_type_JavaLangString = "https://cmshow.qq.com/xydata/cmshow/devAct/7/c4e28479a1f47ff9e3104cf3e96c2430.png";
  }
  
  public boolean a()
  {
    arfo localarfo = (arfo)aqxe.a().a(490);
    return (localarfo != null) && (localarfo.jdField_a_of_type_Int != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axmn
 * JD-Core Version:    0.7.0.1
 */