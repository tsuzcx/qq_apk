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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("praseHomeEntraConfig. error config=");
      localStringBuilder.append(paramString);
      SLog.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", localStringBuilder.toString(), localJSONException);
    }
    return -1;
  }
  
  private StoryAlbumConfig.ConfigInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig is null");
      return null;
    }
    for (;;)
    {
      try
      {
        StoryAlbumConfig.ConfigInfo localConfigInfo = new StoryAlbumConfig.ConfigInfo();
        localObject1 = new JSONObject(paramString);
        i = ((JSONObject)localObject1).optInt("album_state", 1);
        int j = 0;
        if (i == 1)
        {
          bool = true;
          localConfigInfo.jdField_a_of_type_Boolean = bool;
          localConfigInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_mp4");
          localConfigInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_cover");
          localConfigInfo.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("geohashLevel", 8);
          Object localObject2 = ((JSONObject)localObject1).optJSONObject("count_limit");
          if (localObject2 != null)
          {
            localConfigInfo.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("first_scan", 500);
            localConfigInfo.c = ((JSONObject)localObject2).optInt("inc_scan", 100);
            localConfigInfo.jdField_d_of_type_Int = ((JSONObject)localObject2).optInt("first_save", 15);
          }
          if (localConfigInfo.jdField_a_of_type_JavaUtilList == null) {
            localConfigInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          localObject2 = ((JSONObject)localObject1).optJSONObject("home_rule");
          Object localObject3;
          if (localObject2 != null)
          {
            localObject3 = new RuleConfig(2);
            ((RuleConfig)localObject3).a((JSONObject)localObject2, 6);
            localConfigInfo.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          localObject2 = ((JSONObject)localObject1).optJSONObject("native_rule");
          if (localObject2 != null)
          {
            localObject3 = new RuleConfig(4);
            ((RuleConfig)localObject3).a((JSONObject)localObject2, 10);
            localConfigInfo.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          localObject2 = ((JSONObject)localObject1).optJSONObject("foreigner_rule");
          if (localObject2 != null)
          {
            localObject3 = new RuleConfig(3);
            ((RuleConfig)localObject3).a((JSONObject)localObject2, 10);
            localConfigInfo.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          localObject2 = ((JSONObject)localObject1).optJSONArray("festival_list");
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            if (localConfigInfo.jdField_b_of_type_JavaUtilList != null) {
              break label584;
            }
            localConfigInfo.jdField_b_of_type_JavaUtilList = new ArrayList();
            break label584;
            if (i < ((JSONArray)localObject2).length())
            {
              localObject3 = ((JSONArray)localObject2).getJSONObject(i);
              if (localObject3 == null) {
                break label589;
              }
              localObject3 = a((JSONObject)localObject3, false);
              if (localObject3 == null) {
                break label589;
              }
              localConfigInfo.jdField_b_of_type_JavaUtilList.add(localObject3);
              break label589;
            }
          }
          else
          {
            SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have festival_list");
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("mutableFestivalList");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
          {
            i = j;
            if (localConfigInfo.jdField_b_of_type_JavaUtilList == null)
            {
              localConfigInfo.jdField_b_of_type_JavaUtilList = new ArrayList();
              i = j;
            }
            if (i < ((JSONArray)localObject1).length())
            {
              localObject2 = ((JSONArray)localObject1).getJSONObject(i);
              if (localObject2 == null) {
                break label596;
              }
              localObject2 = a((JSONObject)localObject2, true);
              if (localObject2 == null) {
                break label596;
              }
              localConfigInfo.jdField_b_of_type_JavaUtilList.add(localObject2);
              break label596;
            }
          }
          else
          {
            SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have mutableFestivalList");
          }
          return localConfigInfo;
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseAlbumConfig error config=");
        ((StringBuilder)localObject1).append(paramString);
        SLog.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", ((StringBuilder)localObject1).toString(), localJSONException);
        return null;
      }
      boolean bool = false;
      continue;
      label584:
      int i = 0;
      continue;
      label589:
      i += 1;
      continue;
      label596:
      i += 1;
    }
  }
  
  private StoryAlbumConfig.FestivalConfig a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    int i = 1;
    if (paramJSONObject.optInt("type", 1) == 2) {
      i = 6;
    }
    Object localObject = new StoryAlbumConfig.FestivalConfig(i);
    ((StoryAlbumConfig.FestivalConfig)localObject).a(paramJSONObject, 6);
    ((StoryAlbumConfig.FestivalConfig)localObject).c = paramJSONObject.optString("name", "");
    ((StoryAlbumConfig.FestivalConfig)localObject).f = paramJSONObject.optInt("start_age", -2147483648);
    ((StoryAlbumConfig.FestivalConfig)localObject).g = paramJSONObject.optInt("end_age", -2147483648);
    if ((((StoryAlbumConfig.FestivalConfig)localObject).f != -2147483648) && (((StoryAlbumConfig.FestivalConfig)localObject).g != -2147483648))
    {
      if (((StoryAlbumConfig.FestivalConfig)localObject).jdField_a_of_type_Int == 6)
      {
        paramJSONObject = paramJSONObject.optJSONObject("time");
        if (paramJSONObject != null)
        {
          ((StoryAlbumConfig.FestivalConfig)localObject).jdField_d_of_type_JavaLangString = paramJSONObject.optString("start", "");
          ((StoryAlbumConfig.FestivalConfig)localObject).jdField_e_of_type_Int = paramJSONObject.optInt("duration", 24);
          return localObject;
        }
      }
      else
      {
        ((StoryAlbumConfig.FestivalConfig)localObject).jdField_d_of_type_Int = paramJSONObject.optInt("year", 0);
        if ((((StoryAlbumConfig.FestivalConfig)localObject).jdField_d_of_type_Int == 0) && (paramBoolean))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("festival_list error: has no year. config=");
          ((StringBuilder)localObject).append(paramJSONObject);
          SLog.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", ((StringBuilder)localObject).toString());
          return null;
        }
        paramJSONObject = paramJSONObject.optJSONObject("time");
        if (paramJSONObject != null)
        {
          ((StoryAlbumConfig.FestivalConfig)localObject).jdField_d_of_type_JavaLangString = paramJSONObject.optString("start", "");
          ((StoryAlbumConfig.FestivalConfig)localObject).jdField_e_of_type_JavaLangString = paramJSONObject.optString("end", "");
        }
      }
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("festival_list error: has no age. config=");
    ((StringBuilder)localObject).append(paramJSONObject);
    SLog.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", ((StringBuilder)localObject).toString());
    return null;
  }
  
  private SplitConfig.TimeSplitConfig a(@NonNull StoryAlbumConfig.FestivalConfig paramFestivalConfig, Card paramCard, int paramInt)
  {
    paramFestivalConfig = new SplitConfig.TimeSplitConfig(paramFestivalConfig, paramCard, paramInt);
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule year=%d, rule=%s", new Object[] { Integer.valueOf(paramInt), paramFestivalConfig });
    return paramFestivalConfig;
  }
  
  private SplitConfig.TreeGatherConfig a(@NonNull RuleConfig paramRuleConfig)
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
    boolean bool;
    if (paramFestivalConfig.jdField_a_of_type_Int == 1) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    if (paramFestivalConfig.jdField_d_of_type_Int != 0)
    {
      paramFestivalConfig = new SplitConfig.TimeSplitConfig(paramFestivalConfig, paramFestivalConfig.jdField_d_of_type_Int);
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { paramFestivalConfig });
      localArrayList.add(paramFestivalConfig);
      return localArrayList;
    }
    if ((paramLong1 != 0L) && (paramLong2 != 0L))
    {
      long l;
      if (paramLong1 > paramLong2)
      {
        SLog.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
        l = paramLong1;
      }
      else
      {
        l = paramLong2;
        paramLong2 = paramLong1;
      }
      int i = Integer.valueOf(DateUtils.c(paramLong2 * 1000L)).intValue();
      int j = Integer.valueOf(DateUtils.c(l * 1000L)).intValue();
      while (i <= j)
      {
        SplitConfig.TimeSplitConfig localTimeSplitConfig = new SplitConfig.TimeSplitConfig(paramFestivalConfig, i);
        SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { localTimeSplitConfig });
        localArrayList.add(localTimeSplitConfig);
        i += 1;
      }
      return localArrayList;
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
    AssertUtils.fail("initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
    return localArrayList;
  }
  
  private List<SplitConfig.TimeSplitConfig> a(@NonNull StoryAlbumConfig.FestivalConfig paramFestivalConfig, long paramLong1, long paramLong2, Card paramCard)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramFestivalConfig.jdField_e_of_type_Int > 0) && (!TextUtils.isEmpty(paramFestivalConfig.jdField_d_of_type_JavaLangString)))
    {
      int i;
      int j;
      if ((paramLong1 != 0L) && (paramLong2 != 0L))
      {
        long l;
        if (paramLong1 > paramLong2)
        {
          SLog.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
          l = paramLong1;
        }
        else
        {
          l = paramLong2;
          paramLong2 = paramLong1;
        }
        i = Integer.valueOf(DateUtils.c(paramLong2 * 1000L)).intValue();
        j = Integer.valueOf(DateUtils.c(l * 1000L)).intValue();
      }
      while (i <= j)
      {
        localArrayList.add(a(paramFestivalConfig, paramCard, i));
        i += 1;
        continue;
        SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
        AssertUtils.fail("initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
        localArrayList.add(a(paramFestivalConfig, paramCard, Calendar.getInstance().get(1)));
      }
      return localArrayList;
    }
    paramCard = new StringBuilder();
    paramCard.append("init birthday rule failed:");
    paramCard.append(paramFestivalConfig);
    AssertUtils.fail(paramCard.toString(), new Object[0]);
    return localArrayList;
  }
  
  public int a()
  {
    StoryAlbumConfig.ConfigInfo localConfigInfo = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo;
    if (localConfigInfo != null) {
      return localConfigInfo.jdField_d_of_type_Int;
    }
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    StoryAlbumConfig.ConfigInfo localConfigInfo = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo;
    if (localConfigInfo != null)
    {
      if (paramBoolean) {
        return localConfigInfo.c;
      }
      return localConfigInfo.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public List<SplitConfig.TreeGatherConfig> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo;
    if ((localObject != null) && (((StoryAlbumConfig.ConfigInfo)localObject).jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(a((RuleConfig)localIterator.next()));
      }
      return localObject;
    }
    return null;
  }
  
  public List<BaseAlbumFilter> a(long paramLong1, long paramLong2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo;
    if ((localObject1 != null) && (((StoryAlbumConfig.ConfigInfo)localObject1).jdField_b_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_b_of_type_JavaUtilList.isEmpty()))
    {
      Card localCard = a();
      ArrayList localArrayList = new ArrayList();
      if (localCard == null) {
        localObject1 = "card is null";
      } else {
        localObject1 = Byte.valueOf(localCard.age);
      }
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList startTime=%s age=%d", new Object[] { Long.valueOf(paramLong1), localObject1 });
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (StoryAlbumConfig.FestivalConfig)((Iterator)localObject1).next();
          if ((((StoryAlbumConfig.FestivalConfig)localObject2).f >= 0) && ((localCard == null) || (localCard.age < ((StoryAlbumConfig.FestivalConfig)localObject2).f)))
          {
            SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "you are too young. config=%s", new Object[] { localObject2 });
            continue;
          }
          if ((((StoryAlbumConfig.FestivalConfig)localObject2).g >= 0) && ((localCard == null) || (localCard.age > ((StoryAlbumConfig.FestivalConfig)localObject2).g)))
          {
            SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "it's not suitable for you. config=%s", new Object[] { localObject2 });
            continue;
          }
          int i = ((StoryAlbumConfig.FestivalConfig)localObject2).jdField_a_of_type_Int;
          if (i != 1)
          {
            if (i != 6) {
              continue;
            }
            try
            {
              localObject2 = a((StoryAlbumConfig.FestivalConfig)localObject2, paramLong1, paramLong2, localCard).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                SplitConfig.TimeSplitConfig localTimeSplitConfig = (SplitConfig.TimeSplitConfig)((Iterator)localObject2).next();
                if ((localTimeSplitConfig.a > 0L) && (localTimeSplitConfig.b > 0L)) {
                  localArrayList.add(0, new OneDayAlbumFilter(localTimeSplitConfig));
                }
              }
            }
            catch (ParseException localParseException1)
            {
              SLog.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList BirthdayAlbumFilter:%s", localParseException1);
            }
          }
          try
          {
            Object localObject3 = a(localParseException1, paramLong1, paramLong2);
            if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
            {
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                localArrayList.add(new OneDayAlbumFilter((SplitConfig.TimeSplitConfig)((Iterator)localObject3).next()));
              }
            }
          }
          catch (ParseException localParseException2)
          {
            SLog.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList config=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo, localParseException2 });
          }
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public void a()
  {
    String str3 = StoryConfigManager.e();
    if (!TextUtils.isEmpty(str3)) {
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo = a(str3);
    }
    String str2 = StoryConfigManager.f();
    this.jdField_a_of_type_Int = a(str2);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    str2 = str3;
    if (str3 == null) {
      str2 = "";
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.loadConfig homeEntraConfig=%s config=%s ", new Object[] { str1, str2 });
  }
  
  public boolean a()
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.isConfigEnable config=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo });
    return this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo != null;
  }
  
  public boolean a(String paramString)
  {
    StoryAlbumConfig.ConfigInfo localConfigInfo1 = a(paramString);
    boolean bool = false;
    if (localConfigInfo1 != null)
    {
      StoryAlbumConfig.ConfigInfo localConfigInfo2 = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo;
      bool = true;
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleAlbumConfig old config=%s, new config=%s", new Object[] { localConfigInfo2, paramString });
      StoryConfigManager.d(paramString);
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo = localConfigInfo1;
    }
    return bool;
  }
  
  public int b()
  {
    StoryAlbumConfig.ConfigInfo localConfigInfo = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo;
    if (localConfigInfo != null) {
      return localConfigInfo.jdField_a_of_type_Int;
    }
    return 8;
  }
  
  public void b()
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearAlbumConfig");
    StoryConfigManager.d("");
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo = null;
  }
  
  public boolean b()
  {
    StoryAlbumConfig.ConfigInfo localConfigInfo = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryAlbumConfig$ConfigInfo;
    if (localConfigInfo != null) {
      return localConfigInfo.jdField_a_of_type_Boolean;
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "StoryHomeAlbumEntraConfig is null");
      return false;
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig old config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    this.jdField_a_of_type_Int = a(paramString);
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig new config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    if (this.jdField_a_of_type_Int != -1)
    {
      StoryConfigManager.e(paramString);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearStoryHomeAlbumEntraConfig");
    StoryConfigManager.e("");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryAlbumConfig
 * JD-Core Version:    0.7.0.1
 */