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
  private boolean b = false;
  private final QQSettingMeBizBean[] c = { new QQSettingMeBizBean("d_qq_shopping", 1, new QQSettingMeBizBean.Title("QQ直播", "QQlive"), String.valueOf(2130847740), String.valueOf(2130847740), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(101100), "em_drawer_live", true, true, false, true), new QQSettingMeBizBean("d_smallworld", 2, new QQSettingMeBizBean.Title("我的小世界", "My wezone"), String.valueOf(2130847730), String.valueOf(2130847730), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), "", "", false, false, false, false), new QQSettingMeBizBean("d_vip_identity", 3, new QQSettingMeBizBean.Title("开通会员", "Super membership"), String.valueOf(2130847746), String.valueOf(2130847747), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100400), "em_drawer_super_member", true, true, true, false), new QQSettingMeBizBean("d_qqwallet", 4, new QQSettingMeBizBean.Title("我的QQ钱包", "QQ Wallet"), String.valueOf(2130847728), String.valueOf(2130847729), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100007), "em_drawer_qq_wallet", true, true, true, true), new QQSettingMeBizBean("d_decoration", 5, new QQSettingMeBizBean.Title("我的个性装扮", "Look & Feel"), String.valueOf(2130847752), String.valueOf(2130847753), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100005), "em_drawer_dress", true, true, true, false), new QQSettingMeBizBean("d_lovespace", 6, new QQSettingMeBizBean.Title("我的情侣空间", "My love zone"), String.valueOf(2130847701), String.valueOf(2130847701), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100066), "em_drawer_couple_space", true, true, true, true), new QQSettingMeBizBean("d_vip_card", 7, new QQSettingMeBizBean.Title("免流量", "Data-free benefits"), String.valueOf(2130847697), String.valueOf(2130847698), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100500), "em_drawer_sim_card", true, true, true, false), new QQSettingMeBizBean("d_favorite", 8, new QQSettingMeBizBean.Title("我的收藏", "Favorites"), String.valueOf(2130847742), String.valueOf(2130847743), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(103000), "em_drawer_favorites", true, true, true, true), new QQSettingMeBizBean("d_album", 9, new QQSettingMeBizBean.Title("我的相册", "Album"), String.valueOf(2130847750), String.valueOf(2130847751), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100180), "em_drawer_photo_album", true, true, true, true), new QQSettingMeBizBean("d_document", 10, new QQSettingMeBizBean.Title("我的文件", "Documents"), String.valueOf(2130847748), String.valueOf(2130847749), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), String.valueOf(100160), "em_drawer_files", true, true, true, true), new QQSettingMeBizBean("d_video", 11, new QQSettingMeBizBean.Title("我的视频", "Video"), String.valueOf(2130847726), String.valueOf(2130847727), new QQSettingMeBizBean.Action(QQSettingMeBizBean.ActionType.DEFAULT, ""), "", "", false, false, false, false) };
  private QQSettingMeBizBean[] d = this.c;
  
  protected static QQSettingMeMenuConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    int i = 0;
    Object localObject = paramArrayOfQConfItem[0].b;
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
        paramArrayOfQConfItem.d = new QQSettingMeBizBean[((JSONArray)localObject).length()];
        while (i < ((JSONArray)localObject).length())
        {
          QQSettingMeBizBean localQQSettingMeBizBean = QQSettingMeBizBean.a((JSONObject)((JSONArray)localObject).get(i));
          paramArrayOfQConfItem.d[i] = localQQSettingMeBizBean;
          i += 1;
        }
        localObject = paramArrayOfQConfItem.d;
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
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public QQSettingMeBizBean[] b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeMenuConfigBean
 * JD-Core Version:    0.7.0.1
 */