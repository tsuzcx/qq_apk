package com.tencent.biz.qqstory.album;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.album.flter.BaseAlbumFilter;
import com.tencent.biz.qqstory.album.flter.OneDayAlbumFilter;
import com.tencent.biz.qqstory.album.strategy.SplitConfig.TimeSplitConfig;
import com.tencent.biz.qqstory.album.strategy.SplitConfig.TreeGatherConfig;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StoryAlbumConfig
{
  public static final DateFormat a;
  private int jdField_a_of_type_Int = -1;
  private StoryAlbumConfig.ConfigInfo jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo;
  
  static
  {
    jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  }
  
  public StoryAlbumConfig()
  {
    a();
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. config is null");
      return -1;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("story_home_show", -1);
      return i;
    }
    catch (JSONException localJSONException)
    {
      SLog.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. error config=" + paramString, localJSONException);
    }
    return -1;
  }
  
  private StoryAlbumConfig.ConfigInfo a(String paramString)
  {
    boolean bool = true;
    int j = 0;
    if (TextUtils.isEmpty(paramString))
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig is null");
      return null;
    }
    Object localObject1;
    Object localObject2;
    label360:
    int i;
    try
    {
      localConfigInfo = new StoryAlbumConfig.ConfigInfo();
      localObject1 = new JSONObject(paramString);
      if (((JSONObject)localObject1).optInt("album_state", 1) != 1) {
        break label575;
      }
      localConfigInfo.jdField_a_of_type_Boolean = bool;
      localConfigInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_mp4");
      localConfigInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_cover");
      localConfigInfo.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("geohashLevel", 8);
      localObject2 = ((JSONObject)localObject1).optJSONObject("count_limit");
      if (localObject2 != null)
      {
        localConfigInfo.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("first_scan", 500);
        localConfigInfo.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("inc_scan", 100);
        localConfigInfo.d = ((JSONObject)localObject2).optInt("first_save", 15);
      }
      if (localConfigInfo.jdField_a_of_type_JavaUtilList == null) {
        localConfigInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("home_rule");
      if (localObject2 != null)
      {
        localObject3 = new StoryAlbumConfig.RuleConfig(2);
        ((StoryAlbumConfig.RuleConfig)localObject3).a((JSONObject)localObject2, 6);
        localConfigInfo.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("native_rule");
      if (localObject2 != null)
      {
        localObject3 = new StoryAlbumConfig.RuleConfig(4);
        ((StoryAlbumConfig.RuleConfig)localObject3).a((JSONObject)localObject2, 10);
        localConfigInfo.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("foreigner_rule");
      if (localObject2 != null)
      {
        localObject3 = new StoryAlbumConfig.RuleConfig(3);
        ((StoryAlbumConfig.RuleConfig)localObject3).a((JSONObject)localObject2, 10);
        localConfigInfo.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("festival_list");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
        break label445;
      }
      if (localConfigInfo.jdField_b_of_type_JavaUtilList != null) {
        break label563;
      }
      localConfigInfo.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    catch (JSONException localJSONException)
    {
      StoryAlbumConfig.ConfigInfo localConfigInfo;
      Object localObject3;
      SLog.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig error config=" + paramString, localJSONException);
      return null;
    }
    if (i < ((JSONArray)localObject2).length())
    {
      localObject3 = ((JSONArray)localObject2).getJSONObject(i);
      if (localObject3 != null)
      {
        localObject3 = a((JSONObject)localObject3, false);
        if (localObject3 != null)
        {
          localConfigInfo.jdField_b_of_type_JavaUtilList.add(localObject3);
          break label568;
          label445:
          SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have festival_list");
        }
      }
    }
    else
    {
      localObject1 = ((JSONObject)localObject1).optJSONArray("mutableFestivalList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i = j;
        if (localJSONException.jdField_b_of_type_JavaUtilList == null)
        {
          localJSONException.jdField_b_of_type_JavaUtilList = new ArrayList();
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        if (localObject2 != null)
        {
          localObject2 = a((JSONObject)localObject2, true);
          if (localObject2 != null)
          {
            localJSONException.jdField_b_of_type_JavaUtilList.add(localObject2);
            break label581;
            SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have mutableFestivalList");
          }
        }
      }
      else
      {
        return localJSONException;
        label563:
        i = 0;
        break label360;
        label568:
        i += 1;
        break label360;
        label575:
        bool = false;
        break;
      }
      label581:
      i += 1;
    }
  }
  
  private StoryAlbumConfig.FestivalConfig a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    int i = 1;
    if (paramJSONObject.optInt("type", 1) == 2) {
      i = 6;
    }
    StoryAlbumConfig.FestivalConfig localFestivalConfig = new StoryAlbumConfig.FestivalConfig(i);
    localFestivalConfig.a(paramJSONObject, 6);
    localFestivalConfig.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name", "");
    localFestivalConfig.jdField_c_of_type_Int = paramJSONObject.optInt("start_age", -2147483648);
    localFestivalConfig.d = paramJSONObject.optInt("end_age", -2147483648);
    if ((localFestivalConfig.jdField_c_of_type_Int == -2147483648) || (localFestivalConfig.d == -2147483648))
    {
      SLog.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no age. config=" + paramJSONObject);
      return null;
    }
    if (localFestivalConfig.e == 6)
    {
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localFestivalConfig.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localFestivalConfig.jdField_b_of_type_Int = paramJSONObject.optInt("duration", 24);
      }
    }
    for (;;)
    {
      return localFestivalConfig;
      localFestivalConfig.jdField_a_of_type_Int = paramJSONObject.optInt("year", 0);
      if ((localFestivalConfig.jdField_a_of_type_Int == 0) && (paramBoolean))
      {
        SLog.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no year. config=" + paramJSONObject);
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localFestivalConfig.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localFestivalConfig.jdField_c_of_type_JavaLangString = paramJSONObject.optString("end", "");
      }
    }
  }
  
  private SplitConfig.TimeSplitConfig a(@NonNull StoryAlbumConfig.FestivalConfig paramFestivalConfig, Card paramCard, int paramInt)
  {
    paramFestivalConfig = new SplitConfig.TimeSplitConfig(paramFestivalConfig, paramCard, paramInt);
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule year=%d, rule=%s", new Object[] { Integer.valueOf(paramInt), paramFestivalConfig });
    return paramFestivalConfig;
  }
  
  private SplitConfig.TreeGatherConfig a(@NonNull StoryAlbumConfig.RuleConfig paramRuleConfig)
  {
    paramRuleConfig = new SplitConfig.TreeGatherConfig(paramRuleConfig);
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initTreeGatherRule rule=%s", new Object[] { paramRuleConfig });
    return paramRuleConfig;
  }
  
  private Card a()
  {
    Object localObject = QQStoryContext.a().getCurrentAccountUin();
    localObject = (Card)QQEntityManagerFactoryProxy.a((String)localObject).createEntityManager().find(Card.class, (String)localObject);
    if (localObject == null) {
      SLog.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "get current user birthday failed..");
    }
    return localObject;
  }
  
  private List<SplitConfig.TimeSplitConfig> a(@NonNull StoryAlbumConfig.FestivalConfig paramFestivalConfig, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramFestivalConfig.e == 1) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.a(bool);
      if (paramFestivalConfig.jdField_a_of_type_Int == 0) {
        break;
      }
      paramFestivalConfig = new SplitConfig.TimeSplitConfig(paramFestivalConfig, paramFestivalConfig.jdField_a_of_type_Int);
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { paramFestivalConfig });
      localArrayList.add(paramFestivalConfig);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      AssertUtils.a("initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      SLog.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(DateUtils.c(1000L * l)).intValue();
      int j = Integer.valueOf(DateUtils.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        SplitConfig.TimeSplitConfig localTimeSplitConfig = new SplitConfig.TimeSplitConfig(paramFestivalConfig, i);
        SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { localTimeSplitConfig });
        localArrayList.add(localTimeSplitConfig);
        i += 1;
      }
      return localArrayList;
      l = paramLong1;
    }
  }
  
  private List<SplitConfig.TimeSplitConfig> a(@NonNull StoryAlbumConfig.FestivalConfig paramFestivalConfig, long paramLong1, long paramLong2, Card paramCard)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramFestivalConfig.jdField_b_of_type_Int <= 0) || (TextUtils.isEmpty(paramFestivalConfig.jdField_b_of_type_JavaLangString)))
    {
      AssertUtils.a("init birthday rule failed:" + paramFestivalConfig, new Object[0]);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      AssertUtils.a("initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      localArrayList.add(a(paramFestivalConfig, paramCard, Calendar.getInstance().get(1)));
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      SLog.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(DateUtils.c(1000L * l)).intValue();
      int j = Integer.valueOf(DateUtils.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        localArrayList.add(a(paramFestivalConfig, paramCard, i));
        i += 1;
      }
      break;
      l = paramLong1;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.d;
    }
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo != null)
    {
      if (paramBoolean) {
        return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_c_of_type_Int;
      }
      return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public List<SplitConfig.TreeGatherConfig> a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo == null) || (this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(a((StoryAlbumConfig.RuleConfig)localIterator.next()));
    }
    return localArrayList;
  }
  
  public List<BaseAlbumFilter> a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo == null) || (this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    Card localCard = a();
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (localCard == null)
    {
      localObject1 = "card is null";
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList startTime=%s age=%d", new Object[] { Long.valueOf(paramLong1), localObject1 });
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_b_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (StoryAlbumConfig.FestivalConfig)((Iterator)localObject1).next();
        if ((((StoryAlbumConfig.FestivalConfig)localObject2).jdField_c_of_type_Int >= 0) && ((localCard == null) || (localCard.age < ((StoryAlbumConfig.FestivalConfig)localObject2).jdField_c_of_type_Int)))
        {
          SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "you are too young. config=%s", new Object[] { localObject2 });
          continue;
          localObject1 = Byte.valueOf(localCard.age);
          break;
        }
        if ((((StoryAlbumConfig.FestivalConfig)localObject2).d >= 0) && ((localCard == null) || (localCard.age > ((StoryAlbumConfig.FestivalConfig)localObject2).d)))
        {
          SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "it's not suitable for you. config=%s", new Object[] { localObject2 });
          continue;
        }
        switch (((StoryAlbumConfig.FestivalConfig)localObject2).e)
        {
        default: 
          break;
        case 1: 
          try
          {
            localObject2 = a((StoryAlbumConfig.FestivalConfig)localObject2, paramLong1, paramLong2);
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                localArrayList.add(new OneDayAlbumFilter((SplitConfig.TimeSplitConfig)((Iterator)localObject2).next()));
              }
            }
          }
          catch (ParseException localParseException1)
          {
            SLog.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList config=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo, localParseException1 });
          }
        case 6: 
          try
          {
            Iterator localIterator = a(localParseException1, paramLong1, paramLong2, localCard).iterator();
            while (localIterator.hasNext())
            {
              SplitConfig.TimeSplitConfig localTimeSplitConfig = (SplitConfig.TimeSplitConfig)localIterator.next();
              if ((localTimeSplitConfig.a > 0L) && (localTimeSplitConfig.b > 0L)) {
                localArrayList.add(0, new OneDayAlbumFilter(localTimeSplitConfig));
              }
            }
          }
          catch (ParseException localParseException2)
          {
            SLog.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList BirthdayAlbumFilter:%s", localParseException2);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    String str2 = StoryConfigManager.f();
    if (!TextUtils.isEmpty(str2)) {
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo = a(str2);
    }
    String str3 = StoryConfigManager.g();
    this.jdField_a_of_type_Int = a(str3);
    String str1 = str3;
    if (str3 == null) {
      str1 = "";
    }
    if (str2 == null) {
      str2 = "";
    }
    for (;;)
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.loadConfig homeEntraConfig=%s config=%s ", new Object[] { str1, str2 });
      return;
    }
  }
  
  public boolean a()
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.isConfigEnable config=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo });
    return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo != null;
  }
  
  public boolean a(String paramString)
  {
    StoryAlbumConfig.ConfigInfo localConfigInfo = a(paramString);
    if (localConfigInfo != null)
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleAlbumConfig old config=%s, new config=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo, paramString });
      StoryConfigManager.g(paramString);
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo = localConfigInfo;
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_a_of_type_Int;
    }
    return 8;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public void b()
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearAlbumConfig");
    StoryConfigManager.g("");
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo = null;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_a_of_type_Boolean;
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "StoryHomeAlbumEntraConfig is null");
    }
    do
    {
      return false;
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig old config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_Int = a(paramString);
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig new config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    } while (this.jdField_a_of_type_Int == -1);
    StoryConfigManager.h(paramString);
    return true;
  }
  
  public void c()
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearStoryHomeAlbumEntraConfig");
    StoryConfigManager.h("");
    this.jdField_a_of_type_Int = -1;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo != null)
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager mStoryHomeAlbumEntraState=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return this.jdField_a_of_type_Int != 0;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryAlbumConfig
 * JD-Core Version:    0.7.0.1
 */