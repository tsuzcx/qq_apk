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

public class apfj
  extends awry
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public apfj(baxk parambaxk)
  {
    super(parambaxk);
  }
  
  public void a(awog paramawog, awwp paramawwp)
  {
    paramawwp.a().setMaxWidth(800);
    Object localObject = (apfe)paramawog;
    ImageView localImageView = paramawwp.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setImageDrawable(null);
    localImageView.setBackgroundDrawable(null);
    if (((apfe)localObject).a == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((apfe)localObject).a.get(0);
    int i = apue.a(localFileManagerEntity.fileName);
    if ((i == 0) || (i == 2))
    {
      if (bbdj.b(localFileManagerEntity.strThumbPath)) {
        localObject = localFileManagerEntity.strThumbPath;
      }
      for (;;)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramawwp.b().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramawwp.b().getWidth();
        paramawwp = paramawwp.d();
        if ((paramawwp != null) && (!TextUtils.isEmpty(paramawog.d())))
        {
          paramawwp.setText(paramawog.d());
          paramawwp.setVisibility(0);
        }
        paramawog = apuw.a(localFileManagerEntity);
        if (paramawog == null) {
          break;
        }
        paramawog = URLDrawable.getDrawable(paramawog, (URLDrawable.URLDrawableOptions)localObject);
        if (paramawog == null) {
          localImageView.setImageDrawable(localImageView.getContext().getResources().getDrawable(2130843479));
        }
        localImageView.setImageDrawable(paramawog);
        return;
        if (bbdj.b(localFileManagerEntity.strLargeThumPath))
        {
          localObject = localFileManagerEntity.strLargeThumPath;
        }
        else
        {
          if (!bbdj.b(localFileManagerEntity.strFilePath)) {
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
        localImageView.setImageDrawable(BaseApplicationImpl.getContext().getResources().getDrawable(2130843479));
        return;
        if (localFileManagerEntity.getCloudType() == 2) {
          localObject = ((QQAppInterface)localObject).a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
        }
      }
      else
      {
        localFileManagerEntity.strThumbPath = ((String)localObject);
        break;
        apue.a(localImageView, localFileManagerEntity);
        return;
      }
      localObject = "";
    }
  }
  
  public void b(awog paramawog, awwp paramawwp)
  {
    super.b(paramawog, paramawwp);
    if ((paramawwp.a() != null) && (!TextUtils.isEmpty(paramawog.a())))
    {
      paramawwp.a().setVisibility(0);
      paramawwp.a().setText(paramawog.a());
    }
    if ((paramawwp.b() != null) && (!TextUtils.isEmpty(paramawog.b())))
    {
      paramawwp.b().setVisibility(0);
      paramawwp.b().setText(paramawog.b());
    }
    if ((paramawwp.c() != null) && (!TextUtils.isEmpty(paramawog.c())))
    {
      paramawwp.c().setVisibility(0);
      paramawwp.c().setText(paramawog.c());
    }
    if ((paramawog.d() == null) && (paramawwp.d() != null)) {
      paramawwp.d().setVisibility(8);
    }
    if ((paramawwp.d() != null) && (paramawog.d() != null))
    {
      paramawwp.d().setVisibility(0);
      paramawwp.d().setText(paramawog.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfj
 * JD-Core Version:    0.7.0.1
 */