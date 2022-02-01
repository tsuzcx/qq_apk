package com.tencent.biz.qqstory.database;

import android.database.Cursor;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabHaloEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeRecommendActivityReadEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListEntity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.ISQLiteOpenHelper;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQStoryEntityManagerFactory
  extends EntityManagerFactory
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
        String str = SecurityUtile.decode(localCursor1.getString(0));
        Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
        if (localCursor2 != null)
        {
          try
          {
            Object localObject;
            if (str.equals(UserEntry.class.getSimpleName()))
            {
              localObject = UserEntry.class;
            }
            else if (str.equals(StoryEntry.class.getSimpleName()))
            {
              localObject = StoryEntry.class;
            }
            else if (str.equals(StoryVideoEntry.class.getSimpleName()))
            {
              localObject = StoryVideoEntry.class;
            }
            else if (str.equals(StoryVideoListEntry.class.getSimpleName()))
            {
              localObject = StoryVideoListEntry.class;
            }
            else if (str.startsWith(PublishVideoEntry.class.getSimpleName()))
            {
              localObject = PublishVideoEntry.class;
            }
            else if (str.equals(HotTopicEntry.class.getSimpleName()))
            {
              localObject = HotTopicEntry.class;
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramString);
              ((StringBuilder)localObject).append(".");
              ((StringBuilder)localObject).append(str);
              localObject = Class.forName(((StringBuilder)localObject).toString());
            }
            OGEntityManager.extractedStatementByReflect(localArrayList, str, localCursor2, (Class)localObject);
          }
          catch (ClassNotFoundException localClassNotFoundException)
          {
            SLog.b("Q.qqstory.QQStoryEntityManagerFactory", "checkColumnChange", localClassNotFoundException);
          }
          localCursor2.close();
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
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
      SLog.a("Q.qqstory.QQStoryEntityManagerFactory", "checkColumnChange take time:%d", Long.valueOf(System.currentTimeMillis() - l));
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a()
  {
    a(this.mInnerDbHelper.getWritableDatabase());
    createDatabase(this.mInnerDbHelper.getWritableDatabase());
  }
  
  protected void a(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(StoryEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(StoryVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(StoryVideoListEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(UserEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(PublishVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(ReportWatchVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(VideoCollectionEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MemoryInfoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(StoryVideoSimpleInfoEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TroopStoryEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(CardEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TopicInfoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(UnionIdMapEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(ShareGroupListEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DiscoverBannerVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MsgTabNodeEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MsgTabHaloEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MsgTabNodeVidListEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(DownloadingUrlEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(StoryAlbumPicEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(StoryAlbumEntry.class.getSimpleName()));
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qqstory_");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".db");
      this.mInnerDbHelper = SQLiteOpenHelperFacade.a(this, localStringBuilder.toString(), 180);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new UserEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new StoryEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new StoryVideoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new StoryVideoListEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PublishVideoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ReportWatchVideoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new VideoCollectionEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MemoryInfoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new StoryVideoSimpleInfoEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TroopStoryEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new CardEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TopicInfoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new UnionIdMapEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ShareGroupListEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DiscoverBannerVideoEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgTabNodeEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgTabHaloEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgTabNodeVidListEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new DownloadingUrlEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgTabNodeRecommendActivityReadEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new StoryAlbumPicEntry()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new StoryAlbumEntry()));
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
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(PublishVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new PublishVideoEntry()));
    }
    if (paramInt1 < 70) {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("FirstVideoEntry"));
    }
    if (paramInt1 < 90)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TopicInfoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TopicInfoEntry()));
    }
    if (paramInt1 < 98)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(LikeEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new LikeEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(LiveVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new LiveVideoEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MemoryInfoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MemoryInfoEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(OfficialRecommendEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new OfficialRecommendEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(ReportWatchVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ReportWatchVideoEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(UserEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new UserEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(StoryEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new StoryEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(StoryVideoListEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new StoryVideoListEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(VideoCollectionEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new VideoCollectionEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(UnionIdMapEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new UnionIdMapEntity()));
    }
    if (paramInt1 < 102)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(CommentEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new CommentEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(TroopStoryEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new TroopStoryEntry()));
    }
    if (paramInt1 < 112)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(CardEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new CardEntry()));
    }
    if (paramInt1 < 134)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(FeedEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new FeedEntry()));
    }
    if (paramInt1 < 138)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(StoryVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new StoryVideoEntry()));
    }
    if (paramInt1 < 138)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MemoryInfoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MemoryInfoEntry()));
    }
    if (paramInt1 < 158)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MsgTabNodeRecommendActivityReadEntity.TABLE_NAME));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgTabNodeRecommendActivityReadEntity()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MsgTabNodeEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgTabNodeEntity()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MsgTabNodeVidListEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgTabNodeVidListEntity()));
    }
    if (paramInt1 < 178)
    {
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(StoryVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new StoryVideoEntry()));
      paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(StoryAlbumEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new StoryAlbumEntry()));
    }
    a("com.tencent.biz.qqstory.database", paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */