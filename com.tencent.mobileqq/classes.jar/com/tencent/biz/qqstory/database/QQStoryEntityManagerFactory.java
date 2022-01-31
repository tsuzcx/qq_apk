package com.tencent.biz.qqstory.database;

import android.database.Cursor;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListEntity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQStoryEntityManagerFactory
  extends QQEntityManagerFactory
{
  public QQStoryEntityManagerFactory(String paramString)
  {
    super(paramString);
  }
  
  public static void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    long l = System.currentTimeMillis();
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    if (localCursor1 != null)
    {
      while (localCursor1.moveToNext())
      {
        String str = SecurityUtile.b(localCursor1.getString(0));
        Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
        if (localCursor2 != null) {
          for (;;)
          {
            try
            {
              if (!str.equals(UserEntry.class.getSimpleName())) {
                continue;
              }
              localObject = UserEntry.class;
              OGEntityManager.a(localArrayList, str, localCursor2, (Class)localObject);
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              Object localObject;
              SLog.b("Q.qqstory.QQStoryEntityManagerFactory", "checkColumnChange", localClassNotFoundException);
              continue;
            }
            localCursor2.close();
            break;
            if (str.equals(StoryEntry.class.getSimpleName())) {
              localObject = StoryEntry.class;
            } else if (str.equals(StoryVideoEntry.class.getSimpleName())) {
              localObject = StoryVideoEntry.class;
            } else if (str.equals(StoryVideoListEntry.class.getSimpleName())) {
              localObject = StoryVideoListEntry.class;
            } else if (str.startsWith(PublishVideoEntry.class.getSimpleName())) {
              localObject = PublishVideoEntry.class;
            } else if (str.equals(HotTopicEntry.class.getSimpleName())) {
              localObject = HotTopicEntry.class;
            } else {
              localObject = Class.forName(paramString + "." + str);
            }
          }
        }
      }
      localCursor1.close();
    }
    com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramString = localArrayList.iterator();
      while (paramString.hasNext()) {
        paramSQLiteDatabase.execSQL((String)paramString.next());
      }
      paramSQLiteDatabase.setTransactionSuccessful();
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
    }
    paramSQLiteDatabase.endTransaction();
    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
    SLog.a("Q.qqstory.QQStoryEntityManagerFactory", "checkColumnChange take time:%d", Long.valueOf(System.currentTimeMillis() - l));
  }
  
  protected void a(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.a(StoryEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(StoryVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(StoryVideoListEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(UserEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(PublishVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(ReportWatchVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(VideoCollectionEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(MemoryInfoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(StoryVideoSimpleInfoEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(TroopStoryEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(CardEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(TopicInfoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(UnionIdMapEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(ShareGroupListEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(DiscoverBannerVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(MsgTabNodeEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(MsgTabNodeVidListEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(DownloadingUrlEntry.class.getSimpleName()));
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, "qqstory_" + paramString + ".db", null, 149);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.a(new UserEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new StoryEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new StoryVideoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new StoryVideoListEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new PublishVideoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ReportWatchVideoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new VideoCollectionEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new MemoryInfoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new StoryVideoSimpleInfoEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopStoryEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new CardEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new TopicInfoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new UnionIdMapEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new ShareGroupListEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new DiscoverBannerVideoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new MsgTabNodeEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new MsgTabNodeVidListEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.a(new DownloadingUrlEntry()));
  }
  
  protected String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
    {
      a(paramSQLiteDatabase);
      createDatabase(paramSQLiteDatabase);
      SLog.d("Q.qqstory.QQStoryEntityManagerFactory", "Version %d turn to %d ,clear all data", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    if (paramInt1 < 29)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(PublishVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new PublishVideoEntry()));
    }
    if (paramInt1 < 70) {
      paramSQLiteDatabase.execSQL(TableBuilder.a("FirstVideoEntry"));
    }
    if (paramInt1 < 90)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(TopicInfoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new TopicInfoEntry()));
    }
    if (paramInt1 < 98)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(LikeEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new LikeEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(LiveVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new LiveVideoEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(MemoryInfoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new MemoryInfoEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(OfficialRecommendEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new OfficialRecommendEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(ReportWatchVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new ReportWatchVideoEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(UserEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new UserEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(StoryEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new StoryEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(StoryVideoListEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new StoryVideoListEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(VideoCollectionEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new VideoCollectionEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(UnionIdMapEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new UnionIdMapEntity()));
    }
    if (paramInt1 < 102)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(CommentEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new CommentEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(TroopStoryEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new TroopStoryEntry()));
    }
    if (paramInt1 < 112)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(CardEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new CardEntry()));
    }
    if (paramInt1 < 134)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(FeedEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new FeedEntry()));
    }
    if (paramInt1 < 138)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(StoryVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new StoryVideoEntry()));
    }
    if (paramInt1 < 138)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.a(MemoryInfoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.a(new MemoryInfoEntry()));
    }
    a("com.tencent.biz.qqstory.database", paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */