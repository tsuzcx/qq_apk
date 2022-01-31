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

public class apfn
  extends awsa
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public apfn(baxy parambaxy)
  {
    super(parambaxy);
  }
  
  public void a(awoi paramawoi, awwr paramawwr)
  {
    paramawwr.a().setMaxWidth(800);
    Object localObject = (apfi)paramawoi;
    ImageView localImageView = paramawwr.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setImageDrawable(null);
    localImageView.setBackgroundDrawable(null);
    if (((apfi)localObject).a == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((apfi)localObject).a.get(0);
    int i = apug.a(localFileManagerEntity.fileName);
    if ((i == 0) || (i == 2))
    {
      if (bbdx.b(localFileManagerEntity.strThumbPath)) {
        localObject = localFileManagerEntity.strThumbPath;
      }
      for (;;)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramawwr.b().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramawwr.b().getWidth();
        paramawwr = paramawwr.d();
        if ((paramawwr != null) && (!TextUtils.isEmpty(paramawoi.d())))
        {
          paramawwr.setText(paramawoi.d());
          paramawwr.setVisibility(0);
        }
        paramawoi = apuy.a(localFileManagerEntity);
        if (paramawoi == null) {
          break;
        }
        paramawoi = URLDrawable.getDrawable(paramawoi, (URLDrawable.URLDrawableOptions)localObject);
        if (paramawoi == null) {
          localImageView.setImageDrawable(localImageView.getContext().getResources().getDrawable(2130843480));
        }
        localImageView.setImageDrawable(paramawoi);
        return;
        if (bbdx.b(localFileManagerEntity.strLargeThumPath))
        {
          localObject = localFileManagerEntity.strLargeThumPath;
        }
        else
        {
          if (!bbdx.b(localFileManagerEntity.strFilePath)) {
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
        localImageView.setImageDrawable(BaseApplicationImpl.getContext().getResources().getDrawable(2130843480));
        return;
        if (localFileManagerEntity.getCloudType() == 2) {
          localObject = ((QQAppInterface)localObject).a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
        }
      }
      else
      {
        localFileManagerEntity.strThumbPath = ((String)localObject);
        break;
        apug.a(localImageView, localFileManagerEntity);
        return;
      }
      localObject = "";
    }
  }
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    super.b(paramawoi, paramawwr);
    if ((paramawwr.a() != null) && (!TextUtils.isEmpty(paramawoi.a())))
    {
      paramawwr.a().setVisibility(0);
      paramawwr.a().setText(paramawoi.a());
    }
    if ((paramawwr.b() != null) && (!TextUtils.isEmpty(paramawoi.b())))
    {
      paramawwr.b().setVisibility(0);
      paramawwr.b().setText(paramawoi.b());
    }
    if ((paramawwr.c() != null) && (!TextUtils.isEmpty(paramawoi.c())))
    {
      paramawwr.c().setVisibility(0);
      paramawwr.c().setText(paramawoi.c());
    }
    if ((paramawoi.d() == null) && (paramawwr.d() != null)) {
      paramawwr.d().setVisibility(8);
    }
    if ((paramawwr.d() != null) && (paramawoi.d() != null))
    {
      paramawwr.d().setVisibility(0);
      paramawwr.d().setText(paramawoi.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfn
 * JD-Core Version:    0.7.0.1
 */