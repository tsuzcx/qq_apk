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

public class aooo
  extends avsf
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public aooo(azwg paramazwg)
  {
    super(paramazwg);
  }
  
  public void a(avon paramavon, avww paramavww)
  {
    paramavww.a().setMaxWidth(800);
    Object localObject = (aooj)paramavon;
    ImageView localImageView = paramavww.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setImageDrawable(null);
    localImageView.setBackgroundDrawable(null);
    if (((aooj)localObject).a == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((aooj)localObject).a.get(0);
    int i = apck.a(localFileManagerEntity.fileName);
    if ((i == 0) || (i == 2))
    {
      if (bace.b(localFileManagerEntity.strThumbPath)) {
        localObject = localFileManagerEntity.strThumbPath;
      }
      for (;;)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramavww.b().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramavww.b().getWidth();
        paramavww = paramavww.d();
        if ((paramavww != null) && (!TextUtils.isEmpty(paramavon.d())))
        {
          paramavww.setText(paramavon.d());
          paramavww.setVisibility(0);
        }
        paramavon = apdc.a(localFileManagerEntity);
        if (paramavon == null) {
          break;
        }
        paramavon = URLDrawable.getDrawable(paramavon, (URLDrawable.URLDrawableOptions)localObject);
        if (paramavon == null) {
          localImageView.setImageDrawable(localImageView.getContext().getResources().getDrawable(2130843395));
        }
        localImageView.setImageDrawable(paramavon);
        return;
        if (bace.b(localFileManagerEntity.strLargeThumPath))
        {
          localObject = localFileManagerEntity.strLargeThumPath;
        }
        else
        {
          if (!bace.b(localFileManagerEntity.strFilePath)) {
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
        localImageView.setImageDrawable(BaseApplicationImpl.getContext().getResources().getDrawable(2130843395));
        return;
        if (localFileManagerEntity.getCloudType() == 2) {
          localObject = ((QQAppInterface)localObject).a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
        }
      }
      else
      {
        localFileManagerEntity.strThumbPath = ((String)localObject);
        break;
        apck.a(localImageView, localFileManagerEntity);
        return;
      }
      localObject = "";
    }
  }
  
  public void b(avon paramavon, avww paramavww)
  {
    super.b(paramavon, paramavww);
    if ((paramavww.a() != null) && (!TextUtils.isEmpty(paramavon.a())))
    {
      paramavww.a().setVisibility(0);
      paramavww.a().setText(paramavon.a());
    }
    if ((paramavww.b() != null) && (!TextUtils.isEmpty(paramavon.b())))
    {
      paramavww.b().setVisibility(0);
      paramavww.b().setText(paramavon.b());
    }
    if ((paramavww.c() != null) && (!TextUtils.isEmpty(paramavon.c())))
    {
      paramavww.c().setVisibility(0);
      paramavww.c().setText(paramavon.c());
    }
    if ((paramavon.d() == null) && (paramavww.d() != null)) {
      paramavww.d().setVisibility(8);
    }
    if ((paramavww.d() != null) && (paramavon.d() != null))
    {
      paramavww.d().setVisibility(0);
      paramavww.d().setText(paramavon.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aooo
 * JD-Core Version:    0.7.0.1
 */