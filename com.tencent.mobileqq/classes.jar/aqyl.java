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

public class aqyl
  extends aynd
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public aqyl(bcws parambcws)
  {
    super(parambcws);
  }
  
  public void a(ayjl paramayjl, ayru paramayru)
  {
    paramayru.a().setMaxWidth(800);
    Object localObject = (aqyg)paramayjl;
    ImageView localImageView = paramayru.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setImageDrawable(null);
    localImageView.setBackgroundDrawable(null);
    if (((aqyg)localObject).a == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((aqyg)localObject).a.get(0);
    int i = arni.a(localFileManagerEntity.fileName);
    if ((i == 0) || (i == 2))
    {
      if (bdcs.b(localFileManagerEntity.strThumbPath)) {
        localObject = localFileManagerEntity.strThumbPath;
      }
      for (;;)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramayru.b().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramayru.b().getWidth();
        paramayru = paramayru.d();
        if ((paramayru != null) && (!TextUtils.isEmpty(paramayjl.d())))
        {
          paramayru.setText(paramayjl.d());
          paramayru.setVisibility(0);
        }
        paramayjl = aroa.a(localFileManagerEntity);
        if (paramayjl == null) {
          break;
        }
        paramayjl = URLDrawable.getDrawable(paramayjl, (URLDrawable.URLDrawableOptions)localObject);
        if (paramayjl == null) {
          localImageView.setImageDrawable(localImageView.getContext().getResources().getDrawable(2130843839));
        }
        localImageView.setImageDrawable(paramayjl);
        return;
        if (bdcs.b(localFileManagerEntity.strLargeThumPath))
        {
          localObject = localFileManagerEntity.strLargeThumPath;
        }
        else
        {
          if (!bdcs.b(localFileManagerEntity.strFilePath)) {
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
        localImageView.setImageDrawable(BaseApplicationImpl.getContext().getResources().getDrawable(2130843839));
        return;
        if (localFileManagerEntity.getCloudType() == 2) {
          localObject = ((QQAppInterface)localObject).a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
        }
      }
      else
      {
        localFileManagerEntity.strThumbPath = ((String)localObject);
        break;
        arni.a(localImageView, localFileManagerEntity);
        return;
      }
      localObject = "";
    }
  }
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    super.b(paramayjl, paramayru);
    if ((paramayru.a() != null) && (!TextUtils.isEmpty(paramayjl.a())))
    {
      paramayru.a().setVisibility(0);
      paramayru.a().setText(paramayjl.a());
    }
    if ((paramayru.b() != null) && (!TextUtils.isEmpty(paramayjl.b())))
    {
      paramayru.b().setVisibility(0);
      paramayru.b().setText(paramayjl.b());
    }
    if ((paramayru.c() != null) && (!TextUtils.isEmpty(paramayjl.c())))
    {
      paramayru.c().setVisibility(0);
      paramayru.c().setText(paramayjl.c());
    }
    if ((paramayjl.d() == null) && (paramayru.d() != null)) {
      paramayru.d().setVisibility(8);
    }
    if ((paramayru.d() != null) && (paramayjl.d() != null))
    {
      paramayru.d().setVisibility(0);
      paramayru.d().setText(paramayjl.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyl
 * JD-Core Version:    0.7.0.1
 */