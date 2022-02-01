package com.tencent.aelight.camera.ae.config;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CategoryMaterialStoryEntity
  extends Entity
{
  public String additionalFields;
  public String bigId;
  public String bigName;
  public String bigThumbUrl;
  public String id;
  public String packageUrl;
  public int thumbHeight;
  public String thumbUrl;
  public int thumbWidth;
  
  public static List<CategoryMaterialStoryEntity> buildCategoryMaterialEntity(GetCategoryMaterialRsp paramGetCategoryMaterialRsp)
  {
    ArrayList localArrayList = new ArrayList();
    paramGetCategoryMaterialRsp = paramGetCategoryMaterialRsp.Categories.iterator();
    while (paramGetCategoryMaterialRsp.hasNext())
    {
      MetaCategory localMetaCategory = (MetaCategory)paramGetCategoryMaterialRsp.next();
      Iterator localIterator = localMetaCategory.materials.iterator();
      while (localIterator.hasNext())
      {
        MetaMaterial localMetaMaterial = (MetaMaterial)localIterator.next();
        CategoryMaterialStoryEntity localCategoryMaterialStoryEntity = new CategoryMaterialStoryEntity();
        localCategoryMaterialStoryEntity.bigId = localMetaCategory.id;
        localCategoryMaterialStoryEntity.bigName = localMetaCategory.name;
        localCategoryMaterialStoryEntity.bigThumbUrl = localMetaCategory.thumbUrl;
        localCategoryMaterialStoryEntity.id = localMetaMaterial.id;
        localCategoryMaterialStoryEntity.thumbUrl = localMetaMaterial.thumbUrl;
        localCategoryMaterialStoryEntity.thumbWidth = localMetaMaterial.thumbWidth;
        localCategoryMaterialStoryEntity.thumbHeight = localMetaMaterial.thumbHeight;
        localCategoryMaterialStoryEntity.packageUrl = localMetaMaterial.packageUrl;
        localCategoryMaterialStoryEntity.additionalFields = mapToJson(localMetaMaterial.additionalFields);
        localArrayList.add(localCategoryMaterialStoryEntity);
      }
    }
    return localArrayList;
  }
  
  private static String mapToJson(Map<String, String> paramMap)
  {
    return new Gson().toJson(paramMap);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CategoryMaterialStoryEntity{bigId='");
    localStringBuilder.append(this.bigId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bigName='");
    localStringBuilder.append(this.bigName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bigThumbUrl='");
    localStringBuilder.append(this.bigThumbUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thumbUrl='");
    localStringBuilder.append(this.thumbUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thumbWidth=");
    localStringBuilder.append(this.thumbWidth);
    localStringBuilder.append(", thumbHeight=");
    localStringBuilder.append(this.thumbHeight);
    localStringBuilder.append(", packageUrl='");
    localStringBuilder.append(this.packageUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", additionalFields='");
    localStringBuilder.append(this.additionalFields);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.config.CategoryMaterialStoryEntity
 * JD-Core Version:    0.7.0.1
 */