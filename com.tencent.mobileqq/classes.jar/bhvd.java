import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import com.tencent.mobileqq.vas.wallpaper.WallpaperHelper;
import java.io.File;
import kotlin.jvm.functions.Function0;

public class bhvd
  implements Function0<Drawable>
{
  public bhvd(WallpaperHelper paramWallpaperHelper, bhvi parambhvi, bhvc parambhvc, File paramFile) {}
  
  public Drawable a()
  {
    Object localObject2;
    if ((0 == 0) && (arli.c().c()) && (this.jdField_a_of_type_Bhvi.a()))
    {
      localObject2 = bhrj.a().a(this.jdField_a_of_type_Bhvc.b, new Handler(ThreadManagerV2.getFileThreadLooper()), false);
      localObject1 = localObject2;
      if (bhrj.c((Drawable)localObject2)) {
        WallpaperHelper.a(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper, "wallpaper-aetc");
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      if ((localObject1 == null) && (ChatBackgroundManager.b(this.jdField_a_of_type_JavaIoFile))) {
        if (!WallpaperHelper.a(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper))
        {
          localObject2 = VasApngIPCModule.getInstance();
          if (((VasApngIPCModule)localObject2).isLoaded()) {
            WallpaperHelper.a(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper, true);
          }
        }
        else
        {
          if (!WallpaperHelper.a(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper)) {
            break label251;
          }
        }
      }
      label251:
      for (;;)
      {
        try
        {
          localObject2 = new ApngDrawable(this.jdField_a_of_type_JavaIoFile, null);
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            try
            {
              ((ApngDrawable)localObject2).getImage().setSupportGlobalPasued(false);
              WallpaperHelper.a(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper, "wallpaper-apng");
              localObject1 = localObject2;
              localObject4 = localObject1;
              if (localObject1 != null) {}
            }
            catch (Throwable localThrowable3)
            {
              Object localObject4;
              Object localObject3;
              localObject1 = localObject3;
              continue;
            }
            try
            {
              localObject2 = BitmapFactory.decodeFile(this.jdField_a_of_type_Bhvc.b);
              localObject4 = localObject1;
              if (localObject2 != null)
              {
                localObject4 = new BitmapDrawable((Bitmap)localObject2);
                WallpaperHelper.a(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper, "wallpaper-static");
              }
              return localObject4;
              if (!((VasApngIPCModule)localObject2).isSoExists()) {
                break;
              }
              WallpaperHelper.a(this.jdField_a_of_type_ComTencentMobileqqVasWallpaperWallpaperHelper, ((VasApngIPCModule)localObject2).loadSoLib());
              break;
              localThrowable2 = localThrowable2;
              localThrowable2.printStackTrace();
            }
            catch (Throwable localThrowable1)
            {
              localThrowable1.printStackTrace();
              localObject3 = null;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvd
 * JD-Core Version:    0.7.0.1
 */