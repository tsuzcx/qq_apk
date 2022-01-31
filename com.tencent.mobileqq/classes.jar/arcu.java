import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;

public class arcu
  extends ayrm
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public arcu(bdbb parambdbb)
  {
    super(parambdbb);
  }
  
  public void a(aynu paramaynu, aywd paramaywd)
  {
    paramaywd.a().setMaxWidth(800);
    Object localObject = (arcp)paramaynu;
    ImageView localImageView = paramaywd.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setImageDrawable(null);
    localImageView.setBackgroundDrawable(null);
    if (((arcp)localObject).a == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((arcp)localObject).a.get(0);
    int i = arrr.a(localFileManagerEntity.fileName);
    if ((i == 0) || (i == 2))
    {
      if (bdhb.b(localFileManagerEntity.strThumbPath)) {
        localObject = localFileManagerEntity.strThumbPath;
      }
      for (;;)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramaywd.b().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramaywd.b().getWidth();
        paramaywd = paramaywd.d();
        if ((paramaywd != null) && (!TextUtils.isEmpty(paramaynu.d())))
        {
          paramaywd.setText(paramaynu.d());
          paramaywd.setVisibility(0);
        }
        paramaynu = arsj.a(localFileManagerEntity);
        if (paramaynu == null) {
          break;
        }
        paramaynu = URLDrawable.getDrawable(paramaynu, (URLDrawable.URLDrawableOptions)localObject);
        if (paramaynu == null) {
          localImageView.setImageDrawable(localImageView.getContext().getResources().getDrawable(2130843911));
        }
        localImageView.setImageDrawable(paramaynu);
        return;
        if (bdhb.b(localFileManagerEntity.strLargeThumPath))
        {
          localObject = localFileManagerEntity.strLargeThumPath;
        }
        else
        {
          if (!bdhb.b(localFileManagerEntity.strFilePath)) {
            break label266;
          }
          localObject = localFileManagerEntity.strFilePath;
        }
      }
      label266:
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localFileManagerEntity.getCloudType() == 1) {
        localObject = ((QQAppInterface)localObject).a().a(localFileManagerEntity, 7);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localImageView.setImageDrawable(BaseApplicationImpl.getContext().getResources().getDrawable(2130843911));
        return;
        if (localFileManagerEntity.getCloudType() == 2) {
          localObject = ((QQAppInterface)localObject).a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
        }
      }
      else
      {
        localFileManagerEntity.strThumbPath = ((String)localObject);
        break;
        arrr.a(localImageView, localFileManagerEntity);
        return;
      }
      localObject = "";
    }
  }
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    super.b(paramaynu, paramaywd);
    if ((paramaywd.a() != null) && (!TextUtils.isEmpty(paramaynu.a())))
    {
      paramaywd.a().setVisibility(0);
      paramaywd.a().setText(paramaynu.a());
    }
    if ((paramaywd.b() != null) && (!TextUtils.isEmpty(paramaynu.b())))
    {
      paramaywd.b().setVisibility(0);
      paramaywd.b().setText(paramaynu.b());
    }
    if ((paramaywd.c() != null) && (!TextUtils.isEmpty(paramaynu.c())))
    {
      paramaywd.c().setVisibility(0);
      paramaywd.c().setText(paramaynu.c());
    }
    if ((paramaynu.d() == null) && (paramaywd.d() != null)) {
      paramaywd.d().setVisibility(8);
    }
    if ((paramaywd.d() != null) && (paramaynu.d() != null))
    {
      paramaywd.d().setVisibility(0);
      paramaywd.d().setText(paramaynu.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arcu
 * JD-Core Version:    0.7.0.1
 */