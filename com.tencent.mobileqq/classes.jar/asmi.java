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
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.List;

public class asmi
  extends bbck
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public asmi(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  public void a(bayt parambayt, bbhb parambbhb)
  {
    parambbhb.a().setMaxWidth(800);
    Object localObject = (asmd)parambayt;
    ImageView localImageView = parambbhb.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setImageDrawable(null);
    localImageView.setBackgroundDrawable(null);
    if (((asmd)localObject).a == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((asmd)localObject).a.get(0);
    int i = aszt.a(localFileManagerEntity.fileName);
    if ((i == 0) || (i == 2))
    {
      if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.strThumbPath)) {
        localObject = localFileManagerEntity.strThumbPath;
      }
      for (;;)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = parambbhb.b().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = parambbhb.b().getWidth();
        parambbhb = parambbhb.d();
        if ((parambbhb != null) && (!TextUtils.isEmpty(parambayt.d())))
        {
          parambbhb.setText(parambayt.d());
          parambbhb.setVisibility(0);
        }
        parambayt = atal.a(localFileManagerEntity);
        if (parambayt == null) {
          break;
        }
        parambayt = URLDrawable.getDrawable(parambayt, (URLDrawable.URLDrawableOptions)localObject);
        if (parambayt == null) {
          localImageView.setImageDrawable(localImageView.getContext().getResources().getDrawable(2130844201));
        }
        localImageView.setImageDrawable(parambayt);
        return;
        if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.strLargeThumPath))
        {
          localObject = localFileManagerEntity.strLargeThumPath;
        }
        else
        {
          if (!FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
            break label265;
          }
          localFileManagerEntity.getFilePath();
        }
      }
      label265:
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localFileManagerEntity.getCloudType() == 1) {
        localObject = ((QQAppInterface)localObject).getFileManagerEngine().a(localFileManagerEntity, 7);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localImageView.setImageDrawable(BaseApplicationImpl.getContext().getResources().getDrawable(2130844201));
        return;
        if (localFileManagerEntity.getCloudType() == 2) {
          localObject = ((QQAppInterface)localObject).getFileManagerEngine().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
        }
      }
      else
      {
        localFileManagerEntity.strThumbPath = ((String)localObject);
        break;
        aszt.a(localImageView, localFileManagerEntity);
        return;
      }
      localObject = "";
    }
  }
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    super.b(parambayt, parambbhb);
    if ((parambbhb.a() != null) && (!TextUtils.isEmpty(parambayt.a())))
    {
      parambbhb.a().setVisibility(0);
      parambbhb.a().setText(parambayt.a());
    }
    if ((parambbhb.b() != null) && (!TextUtils.isEmpty(parambayt.b())))
    {
      parambbhb.b().setVisibility(0);
      parambbhb.b().setText(parambayt.b());
    }
    if ((parambbhb.c() != null) && (!TextUtils.isEmpty(parambayt.c())))
    {
      parambbhb.c().setVisibility(0);
      parambbhb.c().setText(parambayt.c());
    }
    if ((parambayt.d() == null) && (parambbhb.d() != null)) {
      parambbhb.d().setVisibility(8);
    }
    if ((parambbhb.d() != null) && (parambayt.d() != null))
    {
      parambbhb.d().setVisibility(0);
      parambbhb.d().setText(parambayt.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmi
 * JD-Core Version:    0.7.0.1
 */