package com.tencent.mobileqq.activity.qqsettingme.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQSettingMeMenuConfigBean
{
  public static boolean a = false;
  private final QQSettingMeBizBean[] a;
  private boolean jdField_b_of_type_Boolean = false;
  private QQSettingMeBizBean[] jdField_b_of_type_ArrayOfComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean;
  
  public QQSettingMeMenuConfigBean()
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean = new QQSettingMeBizBean[] { new QQSettingMeBizBean("d_qq_shopping", 1, new QQSettingMeBizBean.Title("直播购物", "QQlive"), String.valueOf(2130846270), String.valueOf(2130846270), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(101100), "em_drawer_live", true, true, false, true), new QQSettingMeBizBean("d_smallworld", 2, new QQSettingMeBizBean.Title("我的小世界", "My wezone"), String.valueOf(2130846260), String.valueOf(2130846260), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), "", "", false, false, false, false), new QQSettingMeBizBean("d_vip_identity", 3, new QQSettingMeBizBean.Title("开通会员", "Super membership"), String.valueOf(2130846276), String.valueOf(2130846277), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100400), "em_drawer_super_member", true, true, true, false), new QQSettingMeBizBean("d_qqwallet", 4, new QQSettingMeBizBean.Title("我的QQ钱包", "QQ Wallet"), String.valueOf(2130846258), String.valueOf(2130846259), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100007), "em_drawer_qq_wallet", true, true, true, true), new QQSettingMeBizBean("d_decoration", 5, new QQSettingMeBizBean.Title("我的个性装扮", "Look & Feel"), String.valueOf(2130846282), String.valueOf(2130846283), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100005), "em_drawer_dress", true, true, true, false), new QQSettingMeBizBean("d_lovespace", 6, new QQSettingMeBizBean.Title("我的情侣空间", "My love zone"), String.valueOf(2130846231), String.valueOf(2130846231), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100066), "em_drawer_couple_space", true, true, true, true), new QQSettingMeBizBean("d_vip_card", 7, new QQSettingMeBizBean.Title("免流量", "Data-free benefits"), String.valueOf(2130846227), String.valueOf(2130846228), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100500), "em_drawer_sim_card", true, true, true, false), new QQSettingMeBizBean("d_favorite", 8, new QQSettingMeBizBean.Title("我的收藏", "Favorites"), String.valueOf(2130846272), String.valueOf(2130846273), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(103000), "em_drawer_favorites", true, true, true, true), new QQSettingMeBizBean("d_album", 9, new QQSettingMeBizBean.Title("我的相册", "Album"), String.valueOf(2130846280), String.valueOf(2130846281), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100180), "em_drawer_photo_album", true, true, true, true), new QQSettingMeBizBean("d_document", 10, new QQSettingMeBizBean.Title("我的文件", "Documents"), String.valueOf(2130846278), String.valueOf(2130846279), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100160), "em_drawer_files", true, true, true, true), new QQSettingMeBizBean("d_video", 11, new QQSettingMeBizBean.Title("我的视频", "Video"), String.valueOf(2130846256), String.valueOf(2130846257), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), "", "", false, false, false, false), new QQSettingMeBizBean("d_minigame", 12, new QQSettingMeBizBean.Title("我的小游戏", "Games"), String.valueOf(2130846254), String.valueOf(2130846254), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100077), "em_drawer_mini_games", true, true, true, true), new QQSettingMeBizBean("d_tencent_document", 13, new QQSettingMeBizBean.Title("腾讯文档", "Tencent document"), String.valueOf(2130846261), String.valueOf(2130846262), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(101700), "em_drawer_txdocs", true, true, true, true) };
  }
  
  protected static QQSettingMeMenuConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    int i = 0;
    Object localObject = paramArrayOfQConfItem[0].a;
    paramArrayOfQConfItem = new QQSettingMeMenuConfigBean();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "parse() content is empty");
      }
      return null;
    }
    try
    {
      localObject = new JSONObject((String)localObject).optJSONArray("group1");
      if ((localObject != null) && (((JSONArray)localObject).length() != 0))
      {
        paramArrayOfQConfItem.jdField_b_of_type_ArrayOfComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean = new QQSettingMeBizBean[((JSONArray)localObject).length()];
        while (i < ((JSONArray)localObject).length())
        {
          QQSettingMeBizBean localQQSettingMeBizBean = QQSettingMeBizBean.a((JSONObject)((JSONArray)localObject).get(i));
          paramArrayOfQConfItem.jdField_b_of_type_ArrayOfComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean[i] = localQQSettingMeBizBean;
          i += 1;
        }
        localObject = paramArrayOfQConfItem.jdField_b_of_type_ArrayOfComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean;
        if ((localObject != null) && (localObject.length > 1)) {
          Arrays.sort((Object[])localObject);
        }
        paramArrayOfQConfItem.a(true);
        return paramArrayOfQConfItem;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "parse() group == null || group.length() == 0");
      }
      return null;
    }
    catch (Exception paramArrayOfQConfItem)
    {
      QLog.e("QQSettingRedesign", 1, "QQSettingMeMenuConfigBean#parse, ", paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public QQSettingMeBizBean[] a()
  {
    boolean bool;
    if (this.jdField_b_of_type_ArrayOfComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean != this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean) {
      bool = true;
    } else {
      bool = false;
    }
    jdField_a_of_type_Boolean = bool;
    return this.jdField_b_of_type_ArrayOfComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeMenuConfigBean
 * JD-Core Version:    0.7.0.1
 */