import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.io.File;

class bkci
  extends SimpleJob<DoodleEmojiItem>
  implements stk
{
  protected long a;
  private final DoodleEmojiItem jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
  private final stw jdField_a_of_type_Stw;
  private long b;
  
  public bkci(DoodleEmojiItem paramDoodleEmojiItem)
  {
    super("DownloadAndUnZipJob");
    if (paramDoodleEmojiItem == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_Stw = new stx();
    this.jdField_a_of_type_Stw.a(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem = paramDoodleEmojiItem;
  }
  
  protected DoodleEmojiItem a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_Stw.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.download_url, bkby.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id), 0L);
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
  }
  
  public void a(String paramString, int paramInt)
  {
    DoodleEmojiItem localDoodleEmojiItem1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
    if (paramInt == 0)
    {
      paramString = bkby.a(localDoodleEmojiItem1.pack_id);
      String str = bkby.b(localDoodleEmojiItem1.pack_id);
      ved.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      ved.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      for (;;)
      {
        int i;
        try
        {
          vyf.d(str);
          i = nav.a(paramString, str);
          if (i == 0)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            vei.b("edit_video", "face_download_timecost", 0, 0, new String[] { localDoodleEmojiItem1.pack_id, l1 - l2 + "" });
            vei.b("edit_video", "face_download_success", 0, 0, new String[] { localDoodleEmojiItem1.pack_id });
            ved.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
            localDoodleEmojiItem1.setLocalEmojiFolderPath(str);
            new File(str).setLastModified(System.currentTimeMillis());
            stb.a().dispatch(new bkcf(localDoodleEmojiItem1, paramInt, true, 0L, 0L));
            return;
          }
        }
        catch (Exception localException)
        {
          ved.d("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
          continue;
        }
        finally
        {
          new File(paramString).delete();
        }
        ved.d("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
        stb.a().dispatch(new bkcf(localDoodleEmojiItem2, i, false, 0L, 0L));
        vei.b("edit_video", "face_download_success", 0, i, new String[] { localDoodleEmojiItem2.pack_id });
      }
    }
    ved.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
    stb.a().dispatch(new bkcf(localDoodleEmojiItem2, paramInt, true, 0L, 0L));
    vei.b("edit_video", "face_download_success", 0, paramInt, new String[] { localDoodleEmojiItem2.pack_id });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    DoodleEmojiItem localDoodleEmojiItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
    if (!TextUtils.equals(localDoodleEmojiItem.download_url, paramString))
    {
      ved.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localDoodleEmojiItem);
      ved.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
    }
    while (paramLong1 <= paramLong2 / 10L + this.b) {
      return;
    }
    ved.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    stb.a().dispatch(new bkcf(localDoodleEmojiItem, 0, false, paramLong2, paramLong1));
    this.b = paramLong1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    ved.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkci
 * JD-Core Version:    0.7.0.1
 */