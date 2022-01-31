import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.io.File;

class bmns
  extends SimpleJob<DoodleEmojiItem>
  implements uic
{
  protected long a;
  private final DoodleEmojiItem jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
  private final uio jdField_a_of_type_Uio;
  private long b;
  
  public bmns(DoodleEmojiItem paramDoodleEmojiItem)
  {
    super("DownloadAndUnZipJob");
    if (paramDoodleEmojiItem == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_Uio = new uip();
    this.jdField_a_of_type_Uio.a(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem = paramDoodleEmojiItem;
  }
  
  protected DoodleEmojiItem a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_Uio.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.download_url, bmni.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id), 0L);
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
  }
  
  public void a(String paramString, int paramInt)
  {
    DoodleEmojiItem localDoodleEmojiItem1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
    if (paramInt == 0)
    {
      paramString = bmni.a(localDoodleEmojiItem1.pack_id);
      String str = bmni.b(localDoodleEmojiItem1.pack_id);
      wsv.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      wsv.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      for (;;)
      {
        int i;
        try
        {
          xmx.d(str);
          i = ndr.a(paramString, str);
          if (i == 0)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            wta.b("edit_video", "face_download_timecost", 0, 0, new String[] { localDoodleEmojiItem1.pack_id, l1 - l2 + "" });
            wta.b("edit_video", "face_download_success", 0, 0, new String[] { localDoodleEmojiItem1.pack_id });
            wsv.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
            localDoodleEmojiItem1.setLocalEmojiFolderPath(str);
            new File(str).setLastModified(System.currentTimeMillis());
            uht.a().dispatch(new bmnp(localDoodleEmojiItem1, paramInt, true, 0L, 0L));
            return;
          }
        }
        catch (Exception localException)
        {
          wsv.d("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
          continue;
        }
        finally
        {
          new File(paramString).delete();
        }
        wsv.d("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
        uht.a().dispatch(new bmnp(localDoodleEmojiItem2, i, false, 0L, 0L));
        wta.b("edit_video", "face_download_success", 0, i, new String[] { localDoodleEmojiItem2.pack_id });
      }
    }
    wsv.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
    uht.a().dispatch(new bmnp(localDoodleEmojiItem2, paramInt, true, 0L, 0L));
    wta.b("edit_video", "face_download_success", 0, paramInt, new String[] { localDoodleEmojiItem2.pack_id });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    DoodleEmojiItem localDoodleEmojiItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
    if (!TextUtils.equals(localDoodleEmojiItem.download_url, paramString))
    {
      wsv.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localDoodleEmojiItem);
      wsv.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
    }
    while (paramLong1 <= paramLong2 / 10L + this.b) {
      return;
    }
    wsv.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    uht.a().dispatch(new bmnp(localDoodleEmojiItem, 0, false, paramLong2, paramLong1));
    this.b = paramLong1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    wsv.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmns
 * JD-Core Version:    0.7.0.1
 */