import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.album.adapter.AENewAlbumListAdapter.1;
import java.util.List;

public class bkqe
  extends bkqd
{
  public long a;
  public boolean b;
  boolean c;
  
  public bkqe(bkqr parambkqr)
  {
    super(parambkqr);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  void a(List<QQAlbumInfo> paramList)
  {
    super.a(paramList);
    ThreadManager.post(new AENewAlbumListAdapter.1(this), 2, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(i))._id.equals("qzone_album")) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (!this.b) || (this.jdField_a_of_type_Long == 0L)) {}
    while (!a()) {
      return;
    }
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo._id = "qzone_album";
    localQQAlbumInfo.name = "空间相册";
    localQQAlbumInfo.mMediaFileCount = ((int)this.jdField_a_of_type_Long);
    this.jdField_a_of_type_JavaUtilList.add(0, localQQAlbumInfo);
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListAdapter", 1, "resetQzoneAlbum");
    }
    notifyDataSetChanged();
  }
  
  protected void b(QQAlbumInfo paramQQAlbumInfo)
  {
    Object localObject;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localObject = (QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      if (!((QQAlbumInfo)localObject)._id.equals("$RecentAlbumId"))
      {
        if (!((QQAlbumInfo)localObject)._id.equals("qzone_album")) {
          break label228;
        }
        this.jdField_a_of_type_JavaUtilList.add(1, paramQQAlbumInfo);
      }
    }
    for (;;)
    {
      if ((this.b) && (this.jdField_a_of_type_Long > 0L) && (a()))
      {
        paramQQAlbumInfo = new QQAlbumInfo();
        paramQQAlbumInfo._id = "qzone_album";
        paramQQAlbumInfo.name = "空间相册";
        paramQQAlbumInfo.mMediaFileCount = ((int)this.jdField_a_of_type_Long);
        this.jdField_a_of_type_JavaUtilList.add(0, paramQQAlbumInfo);
        if (QLog.isColorLevel()) {
          QLog.d("AlbumListAdapter", 1, "addRecentAlbum");
        }
      }
      if (this.c)
      {
        paramQQAlbumInfo = new QQAlbumInfo();
        paramQQAlbumInfo._id = "$CustomAlbumId";
        localObject = xna.a().b();
        if (((List)localObject).size() > 0)
        {
          paramQQAlbumInfo.name = ((LocalMediaInfo)((List)localObject).get(0)).mAlbumName;
          paramQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)((List)localObject).get(0));
        }
        paramQQAlbumInfo.mMediaFileCount = ((List)localObject).size();
        this.jdField_a_of_type_JavaUtilList.add(0, paramQQAlbumInfo);
      }
      return;
      label228:
      this.jdField_a_of_type_JavaUtilList.add(0, paramQQAlbumInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqe
 * JD-Core Version:    0.7.0.1
 */