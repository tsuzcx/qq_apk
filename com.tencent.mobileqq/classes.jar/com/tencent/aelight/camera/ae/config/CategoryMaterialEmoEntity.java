package com.tencent.aelight.camera.ae.config;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.BubbleData;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CategoryMaterialEmoEntity
  extends Entity
{
  public String additionalFields;
  public String bigId;
  public String bigName;
  public String bigThumbUrl;
  public String bubbleId;
  public String bubbleText;
  public String id;
  public String packageUrl;
  public int thumbHeight;
  public String thumbUrl;
  public int thumbWidth;
  
  public static List<CategoryMaterialEmoEntity> buildCategoryMaterialEntity(GetCategoryMaterialRsp paramGetCategoryMaterialRsp)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramGetCategoryMaterialRsp.Categories.iterator();
    while (localIterator1.hasNext())
    {
      MetaCategory localMetaCategory = (MetaCategory)localIterator1.next();
      Iterator localIterator2 = localMetaCategory.materials.iterator();
      while (localIterator2.hasNext())
      {
        MetaMaterial localMetaMaterial = (MetaMaterial)localIterator2.next();
        CategoryMaterialEmoEntity localCategoryMaterialEmoEntity = new CategoryMaterialEmoEntity();
        localCategoryMaterialEmoEntity.bigId = localMetaCategory.id;
        localCategoryMaterialEmoEntity.bigName = localMetaCategory.name;
        localCategoryMaterialEmoEntity.bigThumbUrl = localMetaCategory.thumbUrl;
        Object localObject = paramGetCategoryMaterialRsp.BubbleData;
        String str = "";
        if ((localObject != null) && (paramGetCategoryMaterialRsp.BubbleData.Id.endsWith(localMetaMaterial.id))) {
          localObject = paramGetCategoryMaterialRsp.BubbleData.Id;
        } else {
          localObject = "";
        }
        localCategoryMaterialEmoEntity.bubbleId = ((String)localObject);
        localObject = str;
        if (paramGetCategoryMaterialRsp.BubbleData != null)
        {
          localObject = str;
          if (paramGetCategoryMaterialRsp.BubbleData.Id.endsWith(localMetaMaterial.id)) {
            localObject = paramGetCategoryMaterialRsp.BubbleData.DisplayText;
          }
        }
        localCategoryMaterialEmoEntity.bubbleText = ((String)localObject);
        localCategoryMaterialEmoEntity.id = localMetaMaterial.id;
        localCategoryMaterialEmoEntity.thumbUrl = localMetaMaterial.thumbUrl;
        localCategoryMaterialEmoEntity.thumbWidth = localMetaMaterial.thumbWidth;
        localCategoryMaterialEmoEntity.thumbHeight = localMetaMaterial.thumbHeight;
        localCategoryMaterialEmoEntity.packageUrl = localMetaMaterial.packageUrl;
        localCategoryMaterialEmoEntity.additionalFields = mapToJson(localMetaMaterial.additionalFields);
        localArrayList.add(localCategoryMaterialEmoEntity);
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
    localStringBuilder.append("CategoryMaterialEmoEntity{bigId='");
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
    localStringBuilder.append(", bubbleId='");
    localStringBuilder.append(this.bubbleId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bubbleText='");
    localStringBuilder.append(this.bubbleText);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.config.CategoryMaterialEmoEntity
 * JD-Core Version:    0.7.0.1
 */