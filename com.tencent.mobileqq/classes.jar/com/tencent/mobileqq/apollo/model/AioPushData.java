package com.tencent.mobileqq.apollo.model;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="busId,them,actId")
public class AioPushData
  extends Entity
  implements Comparable<AioPushData>
{
  public String actId;
  public int begTs;
  public int busId;
  public int busType;
  public int dotId;
  public int endTs;
  public String folderIconUrl;
  public boolean isShow;
  public int priority;
  public int spRegion;
  public String them;
  public String url;
  public String wording;
  
  public int compareTo(@NonNull AioPushData paramAioPushData)
  {
    return this.begTs - paramAioPushData.begTs;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof AioPushData)) && (((AioPushData)paramObject).getKey().equals(getKey()));
  }
  
  public String getKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(this.busId));
    localStringBuilder.append(this.them);
    localStringBuilder.append(this.actId);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.busType);
    localStringBuilder.append("#");
    localStringBuilder.append(this.busId);
    localStringBuilder.append("#");
    localStringBuilder.append(this.dotId);
    localStringBuilder.append("#");
    localStringBuilder.append(this.priority);
    localStringBuilder.append("#");
    localStringBuilder.append(this.begTs);
    localStringBuilder.append("#");
    localStringBuilder.append(this.endTs);
    localStringBuilder.append("#");
    localStringBuilder.append(this.wording);
    localStringBuilder.append("#");
    localStringBuilder.append(this.url);
    localStringBuilder.append("#");
    localStringBuilder.append(this.them);
    localStringBuilder.append("#");
    localStringBuilder.append(this.actId);
    localStringBuilder.append("#");
    localStringBuilder.append(this.isShow);
    localStringBuilder.append("#");
    localStringBuilder.append(getId());
    localStringBuilder.append("#");
    localStringBuilder.append(getStatus());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.AioPushData
 * JD-Core Version:    0.7.0.1
 */